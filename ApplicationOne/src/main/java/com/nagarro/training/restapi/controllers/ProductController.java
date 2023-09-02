package com.nagarro.training.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.restapi.models.Product;
import com.nagarro.training.restapi.services.ProductService;

/**
 * 
 * @author harshraj01
 * REST Controller that conatains the handlers for the product endpoints
 */
@RestController
@RequestMapping("/api")
public class ProductController {
	
	//autowiring the product service interface
	@Autowired
	private ProductService productService;
	
	/**
	 * Handler mathod that returns all the products stored in the database
	 * @return List of products
	 */
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return this.productService.getAllProducts();
	}
	
	/**
	 * Handler method to search for product in the databse 
	 * @param query to search in the database
	 * @return ResponseEntity with the List of searched products
	 */
	@GetMapping("/products/{query}")
	public ResponseEntity<List<Product>> searchProduct(@PathVariable String query){
		return ResponseEntity.ok().body(this.productService.search(query));
	}
	
	/**
	 * Handler method to find a product by it's id
	 * @param productId which has to be searched in the database
	 * @return Product found in the database
	 */
	@PostMapping("/products/{productId}")
	public Product getById(@PathVariable String productId) {
		return this.productService.getProductByProductId(productId);
	}
	
	/**
	 * Handler method to get the count of all the products in the database
	 * @return long number of products in the database
	 */
	@GetMapping("/products/count")
	public Long countProducts() {
		return this.productService.countProducts();
	}

}
