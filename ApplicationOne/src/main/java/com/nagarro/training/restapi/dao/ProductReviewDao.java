package com.nagarro.training.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.training.restapi.models.ProductReview;

@Repository
public interface ProductReviewDao extends JpaRepository<ProductReview, String> {
	
	//to find the review based on the id
	ProductReview findByReviewId(String reviewId);

}
