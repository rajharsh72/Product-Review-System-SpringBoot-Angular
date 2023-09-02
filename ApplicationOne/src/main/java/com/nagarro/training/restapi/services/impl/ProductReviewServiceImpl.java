package com.nagarro.training.restapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.restapi.dao.ProductReviewDao;
import com.nagarro.training.restapi.models.Product;
import com.nagarro.training.restapi.models.ProductReview;
import com.nagarro.training.restapi.services.ProductReviewService;
import com.nagarro.training.restapi.services.ProductService;

/**
 * A service class that provides various services/utilities to the ProductReviewController
 * @author harshraj01
 *
 */
@Service
public class ProductReviewServiceImpl implements ProductReviewService {
	
	@Autowired
	private ProductReviewDao productReviewDao;
	
	@Autowired
	private ProductService productService;
	
	/**
	 * Method to add a review for a specified product with its product id
	 */
	@Override
	public ProductReview addReview(ProductReview review, String productId) {
		
		//fetching the product based on its product id
		Product product = this.productService.getProductByProductId(productId);
		
		product.getReview().add(review);
		this.productService.addProduct(product);
		
		review.setProduct(product);
		//setting the default state to false
		review.setState("false");
		//save the review in the database
		this.productReviewDao.save(review);
		return review;
	}
	
	@Override
	/**
	 * Method to update the states based on the admin approval
	 */
	public void updateState(String reviewId, String state) {
		ProductReview review = this.productReviewDao.findByReviewId(reviewId);
		
		review.setState(state);
		this.productReviewDao.save(review);
	}
	
	@Override
	/**
	 * method to count the number of reviews in the database
	 */
	public long countProductReviews() {
		return this.productReviewDao.count();
	}

}
