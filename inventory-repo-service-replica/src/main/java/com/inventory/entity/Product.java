/**
 * 
 */
package com.inventory.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author apasha
 *
 */
@Entity
@Table(name="product")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2648084910339021619L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String productName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="brandId",referencedColumnName="id")
	private Brand brand;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId",referencedColumnName="id")
	private Category category;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sellerId",referencedColumnName="id")
	private SellerImpl seller ;
	
	private String color;
	
	private BigDecimal sellRate;
	
	private BigDecimal netRate;
	
	private Integer quantity ;
	
	private String description ;
	
	private String imgUrls ;
	
	//seperate out images with ; as delimiter
	@Transient
	private List<String> imageUrls;
	
	@Transient
	private List<Product> recommendations;
	
		
	
	public Product() {
		super();
	}
	
	public Product(Product product) {
		super();
		this.id = product.getId();
		this.productName = product.getProductName();
		this.brand = product.getBrand();
		this.category = product.getCategory();
		this.color = product.getColor();
		this.sellRate = product.getSellRate();
		this.netRate = product.getNetRate();
		this.quantity = product.getQuantity();
		this.description = product.getDescription();
		this.imgUrls = product.getImgUrl();
		List<String> imgUrls = new ArrayList<>();
		for(String imgUrl : product.getImageUrls()){
			imgUrls.add(imgUrl);
		}
		this.imageUrls = imgUrls;
		
		List<Product> products = new ArrayList<>();
		for(Product recommededProduct : product.getRecommendations()){
			products.add(recommededProduct);
		}
		this.recommendations = products;
		
		
	}

	public String getImgUrl() {
		return imgUrls;
	}

	public void setImgUrl(String imgUrls) {
		this.imgUrls = imgUrls;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getSellRate() {
		return sellRate;
	}

	public void setSellRate(BigDecimal sellRate) {
		this.sellRate = sellRate;
	}

	public BigDecimal getNetRate() {
		return netRate;
	}

	public void setNetRate(BigDecimal netRate) {
		this.netRate = netRate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<String> getImageUrls() {
		this.imageUrls = new ArrayList<>();
		String imgUrlsString = getImgUrl();
		String[] imgUrlArray = imgUrlsString.split(";");
		for(String imgUrl : imgUrlArray){
			this.imageUrls.add(imgUrl);
		}
		return this.imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<Product> recommendations) {
		this.recommendations = recommendations;
	}

	public SellerImpl getSeller() {
		return seller;
	}

	public void setSeller(SellerImpl seller) {
		this.seller = seller;
	}
	
	
	
	
	
}
