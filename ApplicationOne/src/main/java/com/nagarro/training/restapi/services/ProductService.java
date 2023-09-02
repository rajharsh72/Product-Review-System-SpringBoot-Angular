package com.nagarro.training.restapi.services;

import java.util.List;

import com.nagarro.training.restapi.models.Product;

public interface ProductService {

	List<Product> getAllProducts();

	List<Product> search(String searchKey);

	Product getProductByProductId(String productId);

	Long countProducts();

	Product addProduct(Product product);

}
