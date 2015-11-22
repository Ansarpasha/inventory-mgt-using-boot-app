/**
 * 
 */
package com.inventory.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.inventory.entity.Product;
import com.inventory.repo.ProductRepo;
import com.inventory.repo.ProductRepoImpl;

/**
 * @author apasha
 *
 */
@Service
public class InventoryHibernateRepoService implements InventoryRepoService {
	@Autowired
	private ProductRepo productRepo ;//= new ProductRepoImpl();

	@Override
	public Integer addProductToInventory(Product product) {
		Product savedProduct =productRepo.createOrUpdate(product);
		return savedProduct.getId();
	}

	@Override
	public void updateProductInInventory(Product product) {
		productRepo.update(product);
	}

	@Override
	public Product getProductsById(Integer productId) {
		return productRepo.findOne(productId);
	}

	
	@Override
	public List<Product> getProductsByIds(List<Integer> productIds) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select prd from Product prd where prd.id IN (" + ":prdIds" + ")");
		Map<String, Object> inParamMap = new HashMap<>();
		inParamMap.put("prdIds", productIds);
		return productRepo.findByQuery(queryBuilder.toString(), inParamMap);
	}

	@Override
	public List<Product> getProductByFilter(ProductFilter product) {
		Map<String, Object> inParamMap = new HashMap<>();
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select prd from Product prd where 1=1");

		if (product.getBrandId() != null) {
			queryBuilder.append(" and").append("prd.brandId =");
		}
		if (product.getBusinessGroupId() != null) {
			queryBuilder.append(" and").append("prd.brandId =");
		}
		if (product.getCategoryId() != null) {
			queryBuilder.append(" and").append("prd.brandId =");
		}
		if (product.getSupplerId() != null) {
			queryBuilder.append(" and").append("prd.supplierId =");
		}
		if (product.getProductName() != null) {
			queryBuilder.append(" and").append("prd.productName =" + ":prdName");
			inParamMap.put(":prdName", product.getProductName());
		}
		return productRepo.findByQuery(queryBuilder.toString(), inParamMap);
	}

	@Override
	public Integer removeProductFromInventory(Product product) {
		 productRepo.delete(product);
		 return product.getId();
	}

	
	
	

}
