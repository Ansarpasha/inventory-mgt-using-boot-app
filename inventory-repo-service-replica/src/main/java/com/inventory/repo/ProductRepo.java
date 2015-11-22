package com.inventory.repo;

import java.util.List;
import java.util.Map;

import com.inventory.entity.Product;

public interface ProductRepo {

	Product findOne(Integer id);

	List<Product> findAll();

	List<Product> findByQuery(String query);

	List<Product> findByQuery(String query, Map<String, Object> inParamtersMap);

	void create(Product entity);

	Product update(Product entity);

	void delete(Product entity);

	void deleteById(Integer entityId);

	Product createOrUpdate(Product entity);
}
