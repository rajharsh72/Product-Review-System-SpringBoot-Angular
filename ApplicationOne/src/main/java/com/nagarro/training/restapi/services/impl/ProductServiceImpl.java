package com.nagarro.training.restapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.restapi.dao.ProductDao;
import com.nagarro.training.restapi.models.Product;
import com.nagarro.training.restapi.services.ProductService;

/**
 * Service class implementation for ProductService interface to provide utilities to the
 * Product Controller
 * @author harshraj01
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	/**
	 * Method that returns all the products from the database
	 */
	public List<Product> getAllProducts(){
		return this.productDao.findAll ();
	}
	
	@Override
	/**
	 * Method that searches for the data based on the search key
	 */
	public List<Product> search(String searchKey){
		return this.productDao.findProductByProductNameOrProductId(searchKey);
		
	}
	
	@Override
	/**
	 * Method that returns a Product based on the product id from the database
	 */
	public Product getProductByProductId(String productId) {
		return this.productDao.findProductByProductId(productId);
	}
	
	@Override
	/**
	 * Method to count the number of products in the database
	 */
	public Long countProducts() {
		return this.productDao.count();
	}
	
	@Override
	/**
	 * Method to add a product in the database
	 */
	public Product addProduct(Product product) {
		Product prod = this.productDao.findProductByProductId(product.getProductId());
		if(prod!=null) {
			return null;
		}
		return this.productDao.save(product);
		
	}
	
}
