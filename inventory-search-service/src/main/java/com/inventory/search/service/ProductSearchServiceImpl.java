/**
 * 
 */
package com.inventory.search.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.inventory.search.http.HttpClientService;

import proto.ProductSearchResonse;

/**
 * @author apasha
 *
 */
@Service
public class ProductSearchServiceImpl implements ProductSearchService {
	
	private static final String SERVICE_DISCOVERY_URL = "http://localhost:4444/service/discovery";
	

	@Override
	public ProductSearchResonse getProductById(Integer productId) {
		String serviceProviderUrl = lookUpForServiceProvider("webSearchService",SERVICE_DISCOVERY_URL);
		serviceProviderUrl =serviceProviderUrl+"/"+productId;
		List<NameValuePair> urlParameters = new ArrayList<>();
		HttpResponse response = (HttpResponse) HttpClientService.executeGetRequest(serviceProviderUrl, urlParameters);
		return buildProductSearchResponse(response);
	}

	@Override
	public ProductSearchResonse getProductByName(String productName) {
		String serviceProviderUrl = lookUpForServiceProvider("webSearchService",SERVICE_DISCOVERY_URL);
		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("productName", productName));
		HttpResponse response = (HttpResponse) HttpClientService.executeGetRequest(serviceProviderUrl, urlParameters);
		return buildProductSearchResponse(response);
	}

	@Override
	public ProductSearchResonse getProductByFilter(Integer productId, Integer brandId, Integer businessGroupId,
			Integer categoryId, String productName) {
		String serviceProviderUrl = lookUpForServiceProvider("webSearchService",SERVICE_DISCOVERY_URL);
		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("productId", String.valueOf(productId)));
		urlParameters.add(new BasicNameValuePair("brandId", String.valueOf(brandId)));
		urlParameters.add(new BasicNameValuePair("businessGroupId", String.valueOf(businessGroupId)));
		urlParameters.add(new BasicNameValuePair("categoryId", String.valueOf(categoryId)));
		urlParameters.add(new BasicNameValuePair("productName", productName));
		HttpResponse response = (HttpResponse) HttpClientService.executeGetRequest(serviceProviderUrl+"/filter", urlParameters);
		return buildProductSearchResponse(response);
	}
	

	private ProductSearchResonse buildProductSearchResponse(HttpResponse response) {
		ProductSearchResonse productSearchResonse =null;
		HttpEntity entity = response.getEntity();
		if (entity != null) {
				try {
					productSearchResonse =ProductSearchResonse.parseFrom(entity.getContent());
				} catch (IllegalStateException | IOException e) {
					System.err.println("Unable to construct proto form response");
					e.printStackTrace();
				}
			
		}
		System.out.println(productSearchResonse !=null?productSearchResonse.toString():"empty results");
		return productSearchResonse;
	}
	
	
	public String lookUpForServiceProvider(String serviceName, String serviceDiscoveryUrl) {
		String serviceProviderUrl = null;
		List<NameValuePair> urlParamters = new ArrayList<>();
		urlParamters.add(new BasicNameValuePair("serviceName", serviceName));
		HttpResponse response = (HttpResponse) HttpClientService.executeGetRequest(serviceDiscoveryUrl, urlParamters);
		serviceProviderUrl = getStringValueFromResponse(response);
		return serviceProviderUrl;
	}

	public String getStringValueFromResponse(HttpResponse response) {
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
