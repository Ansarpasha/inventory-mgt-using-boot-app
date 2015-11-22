/**
 * 
 */
package com.registry.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author apasha
 *
 */
public class ServiceDiscovery {

	// public static void main(String args[]){
	// String key1="key1";
	// System.out.println(discoverService(key1));
	// }

	public static String discoverService(String serviceName) {
		String serviceUrl = null;
		String bundle = "serviceRegistry";
		ResourceBundle rb = ResourceBundle.getBundle(bundle);
		System.out.println("Discovering the service provider for :" + serviceName);
		serviceUrl = rb.getString(serviceName);
		System.out.println("Discovered the "+serviceUrl+"  service provider for :" + serviceName);

		return serviceUrl;
	}

}
