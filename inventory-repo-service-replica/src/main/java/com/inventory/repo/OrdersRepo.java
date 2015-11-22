package com.inventory.repo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.inventory.entity.Category;
import com.inventory.entity.Orders;
import com.inventory.entity.Product;

@Service
@Transactional
public class OrdersRepo extends AbstractJpaRepo<Orders> {

	public OrdersRepo() {
		super();
		setClazz(Orders.class);
	}

	@Override
	public void create(Orders entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	public Orders createOrUpdate(Orders entity) {
		Orders order = entityManager.merge(entity);
		entityManager.flush();
		return order;
	}
}
