/**
 * 
 */
package com.inventory.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * @author apasha
 *
 */
@Entity
public class SellerImpl {
	@Id
	@GeneratedValue
	private int id;
	
	private String companyName;
	
	private String contactPersonFirstName;
	
	private String contactLastFirstName;
	
	private String emailAddress ;
	
	private String address ;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String logo;

	@OneToMany(mappedBy="seller")
	private Set<SellerRatingImpl> sellerRating ;
	@Transient
	private BigDecimal avgRating ;
	
	@OneToMany(mappedBy="seller")
	private Set<Product> products;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactPersonFirstName() {
		return contactPersonFirstName;
	}

	public void setContactPersonFirstName(String contactPersonFirstName) {
		this.contactPersonFirstName = contactPersonFirstName;
	}

	public String getContactLastFirstName() {
		return contactLastFirstName;
	}

	public void setContactLastFirstName(String contactLastFirstName) {
		this.contactLastFirstName = contactLastFirstName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public Set<SellerRatingImpl> getSellerRating() {
		return sellerRating;
	}

	public void setSellerRating(Set<SellerRatingImpl> sellerRating) {
		this.sellerRating = sellerRating;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public BigDecimal getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(BigDecimal avgRating) {
		this.avgRating = avgRating;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	
	
}
