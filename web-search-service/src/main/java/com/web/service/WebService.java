/**
 * 
 */
package com.web.service;

import proto.Product;
import proto.ProductSearchRequest;
import proto.ProductSearchResonse;

/**
 * @author apasha
 *
 */
public interface WebService {
	
	Integer addProduct(Product product);
	
	ProductSearchResonse getProductsForFilter(ProductSearchRequest productSearchRequest);
	
	ProductSearchResonse getProductById(Integer productId);

}
