package com.web.inventory.mgmt.service;

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

import com.web.inventory.mgmt.http.HttpClientService;

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
		return Integer.valueOf(getStringValueFromResponse( response));
	}


	@Override
	public Integer updateProduct(Product product) {
		String serviceProviderUrl = lookUpForServiceProvider("inventoryService");
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		// urlParamters.add(new BasicNameValuePair("serviceName", serviceName));
		HttpResponse response = (HttpResponse) HttpClientService.executePutRequest(serviceProviderUrl, nameValuePairs,
				product.toByteArray());
		return Integer.valueOf(getStringValueFromResponse( response));
	}

	private String lookUpForServiceProvider(String serviceName) {
		String serviceProviderUrl = null;
		List<NameValuePair> urlParamters = new ArrayList<>();
		urlParamters.add(new BasicNameValuePair("serviceName", serviceName));
		HttpResponse response = (HttpResponse) HttpClientService.executeGetRequest(SERVICE_DISCOVERY_URL, urlParamters);
		serviceProviderUrl = getStringValueFromResponse( response);
		return serviceProviderUrl;
	}

	private String getStringValueFromResponse( HttpResponse response) {
		String strValue =null;
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
