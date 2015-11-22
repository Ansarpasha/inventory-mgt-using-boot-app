/**
 * 
 */
package com.inventory.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.inventory.entity.Product;
import com.inventory.entity.SellerImpl;

/**
 * @author apasha
 *
 */
@Service
@Transactional
public class SellerJpa extends AbstractJpaRepo<SellerImpl> {
	public SellerJpa(){
		super();
		setClazz(SellerImpl.class);
	}
	
	@Override
	public void create(SellerImpl entity) {
		 entityManager.persist(entity);
		 entityManager.flush();
	}
}
