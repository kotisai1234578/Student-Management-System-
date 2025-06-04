package com.masai.service;

import java.util.List;

import com.masai.model.Product;
import com.masai.model.ProductDto;

public interface ProductService {
    
	public Product addProduct(Product product);
	
	public Product getProduct(Integer ProductId);
	
	public List<Product> getAllProduct();
	
	public Product updateProduct(Integer productId, ProductDto productDto);
	
	public Product removeProduct(Integer ProductId);
}
