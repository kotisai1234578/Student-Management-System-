package com.masai.service;

import java.util.List;

import com.masai.model.Product;

public interface ProductCategoryService {
    
	
	public Product addProductToCategory(Integer catId, Integer productId);
	
	public List<Product> getProductsByCategory(String categoryName);
	
	public Product removeProductFromCategory(Integer catId, Integer productId);
	
}
