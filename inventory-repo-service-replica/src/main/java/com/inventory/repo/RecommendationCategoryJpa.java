/**
 * 
 */
package com.inventory.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.inventory.entity.Product;
import com.inventory.entity.RecommendationCategory;

/**
 * @author apasha
 *
 */
@Service
@Transactional
public class RecommendationCategoryJpa extends AbstractJpaRepo<RecommendationCategory> {
	
	public RecommendationCategoryJpa(){
		super();
		setClazz(RecommendationCategory.class);
	}
	
	@Override
	public void create(RecommendationCategory entity) {
		 entityManager.persist(entity);
		 entityManager.flush();
	}
}
