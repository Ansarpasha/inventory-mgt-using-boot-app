/**
 * 
 */
package com.inventory.endpoint.http;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;

/**
 * @author apasha
 *
 */
public class HttpClientService {
	
	
	public static Object executeGetRequest(String url, List<NameValuePair> urlParameters) {
		HttpResponse response = null;
		HttpClient client = HttpClients.createDefault();
		if(urlParameters.size()!=0){
			String queryString = URLEncodedUtils.format(urlParameters, "UTF-8");
			url = url +"?"+ queryString;
		}
		HttpGet get = new HttpGet(url);
		try {
			response = client.execute(get);
		} catch (IOException e ) {
			System.err.println("Http client call failed");
			e.printStackTrace();
		} catch(Exception ex){
			System.err.println("Http client call failed");
			ex.printStackTrace();
		}
		return response;
	}

	public static Object executePostRequest(String url, List<NameValuePair> nameValuePairs, byte[] bs) {
		HttpResponse response = null;
		HttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		if(bs.length>0){
			post.setEntity(new ByteArrayEntity(bs));           
		}
		try {
			//post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			response = client.execute(post);
		} catch (IOException e ) {
			System.err.println("Http client call failed");
			e.printStackTrace();
		} catch(Exception ex){
			System.err.println("Http client call failed");
			ex.printStackTrace();
		}
		return response;
	}

	public static Object executePutRequest(String url, List<NameValuePair> nameValuePairs) {
		HttpResponse response = null;
		HttpClient client = HttpClients.createDefault();
		HttpPut put = new HttpPut(url);
		try {
			put.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			response = client.execute(put);
		} catch (IOException e ) {
			System.err.println("Http client call failed");
			e.printStackTrace();
		} catch(Exception ex){
			System.err.println("Http client call failed");
			ex.printStackTrace();
		}
		return response;
	}

	public static Object executeDeleteRequest(String url, List<NameValuePair> urlParameters) {
		HttpResponse response = null;
		HttpClient client = HttpClients.createDefault();
		String queryString = URLEncodedUtils.format(urlParameters, "UTF-8");
		HttpDelete delete = new HttpDelete(url+queryString);
		try {
			response = client.execute(delete);
		} catch (IOException e ) {
			System.err.println("Http client call failed");
			e.printStackTrace();
		} catch(Exception ex){
			System.err.println("Http client call failed");
			ex.printStackTrace();
		}
		return response;
	}
}
