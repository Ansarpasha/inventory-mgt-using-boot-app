/**
 * 
 */
package com.inventory.endpoint.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inventory.endpoint.http.HttpClientService;

import proto.Product;

/**
 * @author apasha
 *
 */
@Service
public class CreateOrUpdateProductService extends AbstractService {

	private static final String SERVICE_DISCOVERY_URL = "http://localhost:4444/service/discovery";

	public String addProduct(Product product, MultipartFile[] files, String[] names) {
		String msg = "";
		boolean isFileSaved = saveFileAtServer(names, files, msg);
		if (isFileSaved) {
			msg = addProduct(product);
		}
		return msg;
	}

	private String addProduct(Product product) {
		String productId =null;
		String serviceProviderUrl = lookUpForServiceProvider("inventoryService", SERVICE_DISCOVERY_URL);
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		HttpResponse response = (HttpResponse) HttpClientService.executePostRequest(serviceProviderUrl, nameValuePairs, product.toByteArray());
		if(response.getStatusLine().getStatusCode()==200){
			productId = getStringValueFromResponse(response);
		}else{
			return "Failed to add product";
		}
		return "Successfully added product with id  "+productId;
	}

	
	private boolean saveFileAtServer(String[] names, MultipartFile[] files, String message) {
		if (files.length != names.length)
			return false;

		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				File dir = new File(
						"/Users/apasha/Documents/workspace-sts-3.7.1.RELEASE/images" + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				message = message + "You successfully uploaded file=" + name + "<br />";
			} catch (Exception e) {
				System.err.println("You failed to upload " + name + " => " + e.getMessage());
				return false;
			}
		}
		System.out.println(message);
		return true;
	}

}
