/**
 * 
 */
package com.inventory.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author apasha
 *
 */
@Entity
public class SellerRatingImpl {
	@Id
	private int id ;
	
	private BigDecimal rating ;
	
	@ManyToOne
    @JoinColumn(name="seller_id")
	private SellerImpl seller;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getRating() {
		return rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public SellerImpl getSeller() {
		return seller;
	}

	public void setSeller(SellerImpl seller) {
		this.seller = seller;
	}
	
	
	
	
}
