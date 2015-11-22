package com.inventory.entity;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class BusinessGroup {
	@Id
	@GeneratedValue
	private int id;
	
	private String businessGroupName;
	
	@OneToMany(mappedBy="businessGroup")
	private Set<Category> bgCategories ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusinessGroupName() {
		return businessGroupName;
	}

	public void setBusinessGroupName(String businessGroupName) {
		this.businessGroupName = businessGroupName;
	}

	public Set<Category> getBgCategories() {
		return bgCategories;
	}

	public void setBgCategories(Set<Category> bgCategories) {
		this.bgCategories = bgCategories;
	}
	
	
	
	
	/*
	ELECTRONICS(1,"electronics"),
	FASHION(2,"fashion");
	
	private String description;

    private int id;
	
    public static final Map<Integer, BusinessGroup> lookUp = new HashMap<>();
    
    static{
    	for(BusinessGroup businessGroup : EnumSet.allOf(BusinessGroup.class)){
    		lookUp.put(businessGroup.getId(), businessGroup);
    	}
    }
    public static BusinessGroup get(int id){
    	return lookUp.get(id);
    }
    
    BusinessGroup(int id,String description){
		this.id=id;
		this.description=description;
		
	}

	public String getDescription() {
		return description;
	}
	
	public int getId() {
		return id;
	}*/
}
