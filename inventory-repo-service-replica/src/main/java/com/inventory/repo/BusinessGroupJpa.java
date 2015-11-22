package com.inventory.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.inventory.entity.BusinessGroup;
import com.inventory.entity.Category;

@Service
@Transactional
public class BusinessGroupJpa extends AbstractJpaRepo<BusinessGroup> {

	public BusinessGroupJpa() {
		super();
		setClazz(BusinessGroup.class);
	}

	@Override
	public void create(BusinessGroup entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}
}
