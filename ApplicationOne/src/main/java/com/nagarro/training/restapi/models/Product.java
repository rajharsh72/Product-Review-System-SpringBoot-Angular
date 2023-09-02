package com.nagarro.training.restapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author harshraj01
 * Entity class that stores the product details in the database
 *
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private String productId;			//stores the product id in the database
	
	@Column(name="product_name")
	private String productName;			//stores the product name in the database
	private String color;				//stores the product color in the database
	private String gender;				//stores the product gender in the database
	private String size;				//stores the product size in the database
	private Double price;				//stores the product price in the database
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<ProductReview> review;		//joins the column with the relation One to Many with the reviews

	//getter method to get product id     
	public String getProductId() {
		return productId;
	}

	//setter method to set the product id to the class variables
	public void setProductId(String productId) {
		this.productId = productId;
	}

	//getter method to get product name
	public String getProductName() {
		return productName;
	}
	
	//setter method to set the product name to the class variables
	public void setProductName(String productName) {
		this.productName = productName;
	}

	//getter method to get product color
	public String getColor() {
		return color;
	}

	//setter method to set the product color to the class variables
	public void setColor(String color) {
		this.color = color;
	}

	//getter method to get product gender
	public String getGender() {
		return gender;
	}

	//setter method to set the product gender to the class variables
	public void setGender(String gender) {
		this.gender = gender;
	}

	//getter method to get product size
	public String getSize() {
		return size;
	}

	//setter method to set the product size to the class variables
	public void setSize(String size) {
		this.size = size;
	}

	//getter method to get product price
	public Double getPrice() {
		return price;
	}

	//setter method to set the product price to the class variables
	public void setPrice(Double price) {
		this.price = price;
	}

	//getter method to get product reviews
	@JsonManagedReference
	public List<ProductReview> getReview() {
		return review;
	}

	//setter method to set the product reviews to the class variables
	public void setReview(List<ProductReview> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", color=" + color + ", gender="
				+ gender + ", size=" + size + ", price=" + price + ", review=" + review + "]";
	}
	

}
