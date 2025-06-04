package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.masai.model.ProductDto;
import com.masai.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		if(product == null) throw new ProductException("Product is null") ; 
              
    	  
    		return productRepository.save(product) ;
	}

	@Override
	public Product getProduct(Integer productId) {
		
		return productRepository.findById(productId).orElseThrow(()-> new ProductException("No product available with this id"));
	}

	@Override
	public List<Product> getAllProduct() {
		 
		Pageable pageable = PageRequest.of(0, 10, Sort.by("productName").ascending());
		
		List<Product> products = productRepository.findAll(pageable).getContent();
		
		if(products.isEmpty()) throw new ProductException("No product available in the database");
		return products;
		
	}

	@Override
	public Product updateProduct(Integer productId, ProductDto productDto) {
		  
		Optional<Product> product = productRepository.findById(productId);
		
		if(product.isPresent()) {
			Product existingProduct = product.get();
			
			existingProduct.setPrice(productDto.getPrice());
			existingProduct.setRating(productDto.getRating());
			
			return productRepository.save(existingProduct);
		}else
			throw new ProductException("Invalid Product Id");
	}

	@Override
	public Product removeProduct(Integer ProductId) {
		   Optional<Product> opt = productRepository.findById(ProductId);
		   
		   if(opt.isPresent()) {
			  Product existingProduct = opt.get();
			  
			  productRepository.delete(existingProduct);
			  return existingProduct;
		   }
		   else
			  throw new ProductException("Invalid Product Id");
		
	}

}
