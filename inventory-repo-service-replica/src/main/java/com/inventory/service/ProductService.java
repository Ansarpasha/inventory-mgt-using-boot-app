/**
 * 
 */
package com.inventory.service;

import java.util.List;

import com.inventory.entity.Product;

import proto.ProductSearchRequest;
import proto.ProductSearchResonse;

/**
 * @author apasha
 *
 */
public interface ProductService {

	public Integer addProductToInventory(proto.Product product);
	
	public ProductSearchResonse getProductsForFilter(ProductSearchRequest productSearchRequest);
	
	public ProductSearchResonse getProductById(Integer id);
	
	public List<Product> getProductByIds(List<Integer> productIds);
	
}
