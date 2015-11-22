/**
 * 
 */
package com.inventory.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.inventory.entity.Category;
import com.inventory.entity.Product;
import com.inventory.entity.SellerImpl;

/**
 * @author apasha
 *
 */
@Service
@Transactional
public class CategoryJpa extends AbstractJpaRepo<Category> {
	public CategoryJpa(){
		super();
		setClazz(Category.class);
	}
	@Override
	public void create(Category entity) {
		 entityManager.persist(entity);
		 entityManager.flush();
	}
}
