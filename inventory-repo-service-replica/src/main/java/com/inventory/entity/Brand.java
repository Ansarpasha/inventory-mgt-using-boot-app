package com.inventory.entity;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Brand {
	@Id
	private int id ;
	
	private String brandName;

	@OneToMany(mappedBy="brand")
	private Set<Product> products ;
	
	public Brand() {
		super();
	}

	public Brand(int id, String brandName) {
		super();
		this.id = id;
		this.brandName = brandName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	
	
	
	/*
	MOTO(1,"moto"),
	SONY(2,"sony");
	
	private String description;

    private int id;
	
    public static final Map<Integer, Brand> lookUp = new HashMap<>();
    
    static{
    	for(Brand brand : EnumSet.allOf(Brand.class)){
    		lookUp.put(brand.getId(), brand);
    	}
    }
    public static Brand get(int id){
    	return lookUp.get(id);
    }
    
    Brand(int id,String description){
		this.id=id;
		this.description=description;
		
	}

	public String getDescription() {
		return description;
	}
	
	public int getId() {
		return id;
	}
	*/

}
