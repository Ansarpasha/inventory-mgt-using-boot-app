package com.inventory.service;

import java.util.List;

import com.inventory.entity.Product;

public interface InventoryRepoService {
	Integer addProductToInventory(Product product);
	
	void updateProductInInventory(Product product);
	
	List<Product> getProductsByIds(List<Integer> productIds);
	
	Product getProductsById(Integer productId);
	
	List<Product> getProductByFilter(ProductFilter product);
	
	Integer removeProductFromInventory(Product product);
	
	
}
