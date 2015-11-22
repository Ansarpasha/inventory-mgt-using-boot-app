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
import org.springframework.stereotype.Service;

import com.inventory.endpoint.http.HttpClientService;

import proto.ProductCheckoutRequest;
import proto.ProductCheckoutResponse;
import proto.ProductSearchResonse;

/**
 * @author apasha
 *
 */
@Service
public class CheckoutService extends AbstractService {

	private static final String SERVICE_DISCOVERY_URL = "http://localhost:4444/service/discovery";

	public ProductCheckoutResponse checkOutProduct(ProductCheckoutRequest productCheckoutRequest) throws Exception {
		ProductCheckoutResponse productCheckoutResponse = null;
		String serviceProviderUrl = lookUpForServiceProvider("inventoryService", SERVICE_DISCOVERY_URL);
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		HttpResponse response = (HttpResponse) HttpClientService.executePostRequest(serviceProviderUrl + "/checkout",
				nameValuePairs, productCheckoutRequest.toByteArray());
		System.out.println("Received an response with status code \t :" + response.getStatusLine().getStatusCode());
		if (response.getStatusLine().getStatusCode() == 200) {
			productCheckoutResponse = getProductCheckoutResponseFromResponse(response);
		} else {
			throw new Exception("Unable to checkout the product");
		}
		return productCheckoutResponse;
	}

	private ProductCheckoutResponse getProductCheckoutResponseFromResponse(HttpResponse response) {
		ProductCheckoutResponse productSearchResonse = null;
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			try {
				productSearchResonse = ProductCheckoutResponse.parseFrom(entity.getContent());
			} catch (IllegalStateException | IOException e) {
				System.err.println("Unable to construct proto form response");
				e.printStackTrace();
			}

		}
		System.out.println(productSearchResonse.toString());
		return productSearchResonse;
	}
}
