package com.nagarro.training.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.restapi.models.ProductReview;
import com.nagarro.training.restapi.services.ProductReviewService;

/**
 * REST Controller that containe all the handler method to review any product
 * @author harshraj01
 *
 */
@RestController
@RequestMapping("/api")
public class ProductReviewController {
	
	//autowiring the product review service interface
	@Autowired 
	private ProductReviewService productReviewService;
	
	/**
	 * Handler method to that is used to add a review to a particular product
	 * @param review the content of the review
	 * @param productId the id of the product adding a review
	 * @return ResponseEntity with the status 200
	 */
	@PostMapping("/add-review/{productId}")
	public ResponseEntity addReview(@RequestBody ProductReview review, @PathVariable String productId) {
		this.productReviewService.addReview(review, productId);
		return ResponseEntity.status(200).build();
	}
	
	/**
	 * Handler method for the admin to approve or reject the state of the review
	 * @param reviewId the id of the review
	 * @param state the updated state of the review
	 * @return ResponseEntity with the status OK
	 */
	@PostMapping("/admin/update/{reviewId}")
	public ResponseEntity updateReview(@PathVariable String reviewId, @RequestBody String state) {
		this.productReviewService.updateState(reviewId, state);
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Handler method that returns the count of number of reviews in the database
	 * @return long value of the count of reviews in the database
	 */
	@GetMapping("/productReviews/count")
	public long countProductReviews() {
		return this.productReviewService.countProductReviews();
	}

}
