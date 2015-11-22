/**
 * 
 */
package com.web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.web.http.HttpClientService;

/**
 * @author apasha
 *
 */
public abstract class AbstractWebService {
	
	private  static final String SERVICE_DISCOVERY_URL = "http://localhost:4444/service/discovery";
	

	private String lookUpForServiceProvider(String serviceName) {
		String serviceProviderUrl =null;
		List<NameValuePair> urlParamters = new ArrayList<>();
		urlParamters.add(new BasicNameValuePair("serviceName", serviceName));
		HttpResponse response=(HttpResponse) HttpClientService.executeGetRequest(SERVICE_DISCOVERY_URL, urlParamters);
		HttpEntity entity = response.getEntity();
        if (entity != null) {
        	try {
				serviceProviderUrl = EntityUtils.toString(entity);
			} catch (ParseException | IOException e) {
				System.err.println("Error while getting the data from response");
				e.printStackTrace();
			}
        }
        return serviceProviderUrl;
	}
}
