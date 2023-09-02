package com.nagarro.training.restapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.training.restapi.models.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, String> {
	
	//query to search for the products based on name, color or id of the product
	@Query("SELECT p  FROM Product p WHERE "+
			"p.productName LIKE CONCAT('%',:query, '%')" +
			"Or p.productId LIKE CONCAT('%',:query, '%')" + 
			"Or p.color LIKE CONCAT('%',:query, '%')")
	public List<Product> findProductByProductNameOrProductId(String query);
	
	public Product findProductByProductId(String productId);
}

