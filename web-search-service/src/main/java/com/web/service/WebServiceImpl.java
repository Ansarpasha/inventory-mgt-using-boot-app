package com.web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.web.http.HttpClientService;

import proto.Product;
import proto.ProductSearchRequest;
import proto.ProductSearchResonse;

@Service
public class WebServiceImpl implements WebService {

	private static final String SERVICE_DISCOVERY_URL = "http://localhost:4444/service/discovery";

	@Override
	public Integer addProduct(Product product) {
		String serviceProviderUrl = lookUpForServiceProvider("inventoryService");
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		// urlParamters.add(new BasicNameValuePair("serviceName", serviceName));
		HttpResponse response = (HttpResponse) HttpClientService.executePostRequest(serviceProviderUrl, nameValuePairs,
				product.toByteArray());
		return Integer.valueOf(getStringValueFromResponse(response));
	}

	@Override
	public ProductSearchResonse getProductsForFilter(ProductSearchRequest productSearchRequest) {
		return null;
	}

	@Override
	public ProductSearchResonse getProductById(Integer productId) {
		String serviceProviderUrl = lookUpForServiceProvider("inventoryService");
		List<NameValuePair> urlParameters = new ArrayList<>();
		HttpResponse response = (HttpResponse) HttpClientService.executeGetRequest(serviceProviderUrl + "/" + productId,
				urlParameters);
		ProductSearchResonse productSearchResponse = buildProductSearchResponse(response);

		Long recommendedCategoryId = productSearchResponse.getProduct(0).getCategory().getRecommededCategoryId();
		List<NameValuePair> urlParametersForRecommendations = new ArrayList<>();
		urlParametersForRecommendations
				.add(new BasicNameValuePair("categoryId", String.valueOf(recommendedCategoryId.intValue())));
		HttpResponse responseForRecommendations = (HttpResponse) HttpClientService.executeGetRequest(serviceProviderUrl,
				urlParametersForRecommendations);
		ProductSearchResonse recSearchResponse = buildProductSearchResponse(responseForRecommendations);

		productSearchResponse.getProduct(0).newBuilder().addAllRecommendations(recSearchResponse.getProductList()).build();
		
		
		
		return productSearchResponse;
	}

	private ProductSearchResonse buildProductSearchResponse(HttpResponse response) {
		ProductSearchResonse productSearchResonse = null;
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			try {
				productSearchResonse = ProductSearchResonse.parseFrom(entity.getContent());
			} catch (IllegalStateException | IOException e) {
				System.err.println("Unable to construct proto form response");
				e.printStackTrace();
			}

		}
		System.out.println(productSearchResonse.toString());
		return productSearchResonse;
	}

	private String lookUpForServiceProvider(String serviceName) {
		String serviceProviderUrl = null;
		List<NameValuePair> urlParamters = new ArrayList<>();
		urlParamters.add(new BasicNameValuePair("serviceName", serviceName));
		HttpResponse response = (HttpResponse) HttpClientService.executeGetRequest(SERVICE_DISCOVERY_URL, urlParamters);
		serviceProviderUrl = getStringValueFromResponse(response);
		return serviceProviderUrl;
	}

	private String getStringValueFromResponse(HttpResponse response) {
		String strValue = null;
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			try {
				strValue = EntityUtils.toString(entity);
			} catch (ParseException | IOException e) {
				System.err.println("Error while getting the data from response");
				e.printStackTrace();
			}
		}
		return strValue;
	}

}
