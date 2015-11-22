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

import com.inventory.endpoint.http.HttpClientService;

/**
 * @author apasha
 *
 */
public abstract class AbstractService {

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
