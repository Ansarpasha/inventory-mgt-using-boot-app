/**
 * 
 */
package com.inventory.repo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.inventory.entity.Product;
import com.inventory.entity.Product;

/**
 * @author apasha
 *
 */

@Service
@Transactional
public class ProductRepoImpl extends AbstractJpaRepo<Product>implements ProductRepo {
	
	public ProductRepoImpl(){
		super();
		setClazz(Product.class);
	}
	
	@Override
	public void create(Product entity) {
		 entityManager.merge(entity);//(entity);
		 entityManager.flush();
	}
	
	public Product createOrUpdate(Product entity) {
		 Product product =entityManager.merge(entity);//(entity);
		 entityManager.flush();
		 return product;
		 
	}

	@Override
	public Product update(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByQuery(String queryString, Map<String, Object> inParamtersMap) {
		Query query =entityManager.createQuery(queryString);
		for(Entry<String, Object> currentEntry : inParamtersMap.entrySet()){
			query.setParameter(currentEntry.getKey(), currentEntry.getValue());
		}
		return query.getResultList();
	}
	
	

}
