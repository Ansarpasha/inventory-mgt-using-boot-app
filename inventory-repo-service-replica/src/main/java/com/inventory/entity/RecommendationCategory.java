package com.inventory.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RecommendationCategory {
	@Id
	@GeneratedValue
	private Integer id ;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rec_category_id",referencedColumnName="id")
	private Category category ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
