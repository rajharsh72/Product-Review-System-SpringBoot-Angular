package com.nagarro.training.restapi.services;

import com.nagarro.training.restapi.models.ProductReview;

public interface ProductReviewService {

	ProductReview addReview(ProductReview review, String productId);

	void updateState(String productId, String state);

	long countProductReviews();
	

}
