/**
 * 
 */
package com.inventory.endpoint.service;

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

import com.inventory.endpoint.http.HttpClientService;

import proto.ProductSearchRequest;
import proto.ProductSearchResonse;

/**
 * @author apasha
 *
 */
@Service
public class ProductSearchService extends AbstractService{
	
	private static final String SERVICE_DISCOVERY_URL = "http://localhost:4444/service/discovery";
	
	public ProductSearchResonse getProductById(Integer productId) {
		String serviceProviderUrl = lookUpForServiceProvider("searchService",SERVICE_DISCOVERY_URL);
		serviceProviderUrl =serviceProviderUrl+"/"+productId;
		List<NameValuePair> urlParameters = new ArrayList<>();
		HttpResponse response = (HttpResponse) HttpClientService.executeGetRequest(serviceProviderUrl, urlParameters);
		return buildProductSearchResponse(response);
	}

	public ProductSearchResonse getProductByName(String productName) {
		String serviceProviderUrl = lookUpForServiceProvider("searchService",SERVICE_DISCOVERY_URL);
		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("productName", productName));
		HttpResponse response = (HttpResponse) HttpClientService.executeGetRequest(serviceProviderUrl, urlParameters);
		return buildProductSearchResponse(response);
	}

	public ProductSearchResonse getProductByFilter(final Integer productId, final Integer brandId,
			final Integer businessGroupId, final Integer categoryId, final String productName) {
		String serviceProviderUrl = lookUpForServiceProvider("searchService",SERVICE_DISCOVERY_URL);
		List<NameValuePair> urlParameters = new ArrayList<>();
		urlParameters.add(new BasicNameValuePair("productId", String.valueOf(productId)));
		urlParameters.add(new BasicNameValuePair("brandId", String.valueOf(brandId)));
		urlParameters.add(new BasicNameValuePair("businessGroupId", String.valueOf(businessGroupId)));
		urlParameters.add(new BasicNameValuePair("categoryId", String.valueOf(categoryId)));
		urlParameters.add(new BasicNameValuePair("productName", productName));
		HttpResponse response = (HttpResponse) HttpClientService.executeGetRequest(serviceProviderUrl, urlParameters);
		return buildProductSearchResponse(response);
	}

	public ProductSearchResonse getProductByFilter(ProductSearchRequest productSearchRequest) {
		
		return null;
	}
	
	
	private ProductSearchResonse buildProductSearchResponse(HttpResponse response) {
		ProductSearchResonse productSearchResonse =null;
		HttpEntity entity = response.getEntity();
		if (entity != null) {
				try {
					productSearchResonse =ProductSearchResonse.parseFrom(entity.getContent());
				} catch (Exception e) {
					System.err.println("Unable to construct proto form response");
					e.printStackTrace();
				}
			
		}
		System.out.println(productSearchResonse !=null?productSearchResonse.toString():"empty results");
		return productSearchResonse;
	}
}
