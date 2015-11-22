package com.inventory.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrdersDetail {
	@Id
	@GeneratedValue
	private Integer id ;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="productId",referencedColumnName="id")
	private Product product;
	
	private Integer qty;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="orderId",referencedColumnName="id")
	private Orders order;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
	
}
