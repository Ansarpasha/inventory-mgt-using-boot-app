package com.inventory.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Product_Category")
public class Category {
	
	@Id
	@GeneratedValue
	private int id ;
	
	private String categoryName;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="businessGroupId",referencedColumnName="id")
	private BusinessGroup businessGroup ;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rec_cat_id",referencedColumnName="id")
	private RecommendationCategory recommendationCategory ;
	
	
	
	
	public Category() {
		super();
	}

	public Category(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BusinessGroup getBusinessGroup() {
		return businessGroup;
	}

	public void setBusinessGroup(BusinessGroup businessGroup) {
		this.businessGroup = businessGroup;
	}

	public RecommendationCategory getRecommendationCategory() {
		return recommendationCategory;
	}

	public void setRecommendationCategory(RecommendationCategory recommendationCategory) {
		this.recommendationCategory = recommendationCategory;
	}

	
	
	/*
	MOBILE(1, "mobile Phones"), LAPTOP(2, "laptops"), MOBILE_ESSENTIALS(3, "mobile essentials"), LAPTOP_ESSENTIALS(4,
			"laptops essentials");

	private String description;

	private int id;

	public static final Map<Integer, Category> lookUp = new HashMap<>();

	static {
		for (Category category : EnumSet.allOf(Category.class)) {
			lookUp.put(category.getId(), category);
		}
	}

	public static Category get(int id) {
		return lookUp.get(id);
	}

	Category(int id, String description) {
		this.id = id;
		this.description = description;

	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}*/

}
