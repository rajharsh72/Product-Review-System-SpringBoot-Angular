package com.nagarro.training.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author harshraj01
 * Entity class to store the product reviews in the database with the corresponding product id
 */

@Entity
@Table(name="productReview")
public class ProductReview {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="review_id")
	private String reviewId;			//stores the id of a review
	private String review;				//stores the content of a review
	private String state;				//stores the state of a review
	private int rating;					//stores the rating of a product 
	
	
	@ManyToOne
	private Product product;			//foreign key reference for product

	//getter method to get the review id
	public String getReviewId() {
		return reviewId;
	}

	//setter method to assign the value to the class variables
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}

	//getter method to get the review content
	public String getReview() {
		return review;
	}

	//setter method to assign the value to the class variables
	public void setReview(String review) {
		this.review = review;
	}

	//getter method to get the rating of a product
	public int getRating() {
		return rating;
	}

	//setter method to assign the value to the class variables
	public void setRating(int rating) {
		this.rating = rating;
	}

	//getter method to get the review state
	public String getState() {
		return state;
	}

	//setter method to assign the value to the class variables
	public void setState(String state) {
		this.state = state;
	}

	//getter method to get the product
	@JsonBackReference
	public Product getProduct() {
		return product;
	}

	//setter method to assign the value to the class variables
	public void setProduct(Product product) {
		this.product = product;
	}

	

}
