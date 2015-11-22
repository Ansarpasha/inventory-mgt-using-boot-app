/**
 * 
 */
package com.web.inventory.mgmt.service;

import proto.Product;
import proto.ProductSearchRequest;
import proto.ProductSearchResonse;

/**
 * @author apasha
 *
 */
public interface WebService {
	
	Integer addProduct(Product product);
	
	Integer updateProduct(Product product);

}
