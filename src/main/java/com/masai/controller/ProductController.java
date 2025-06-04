package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Product;
import com.masai.model.ProductDto;
import com.masai.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
   
	@Autowired
	private ProductService productService;
	
	@PostMapping("products")
	public ResponseEntity<Product> addNewProduct(@RequestBody @Valid Product product){
		   
		Product pro = productService.addProduct(product);
		
		return new ResponseEntity<>(pro,HttpStatus.CREATED);
	}
	
	@GetMapping("products/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") Integer productId){
		   
		Product pro = productService.getProduct(productId);
		
		return new ResponseEntity<>(pro,HttpStatus.OK);
	}
	
	@GetMapping("products")
	public ResponseEntity<List<Product>> getAllProduct(){
		   
		List<Product> pro = productService.getAllProduct();
		
		return new ResponseEntity<>(pro,HttpStatus.OK);
	}
	
	@PutMapping("products/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable("productId") Integer productId, @RequestBody @Valid ProductDto productdto){
		   
		Product pro = productService.updateProduct(productId, productdto);
		
		return new ResponseEntity<>(pro,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("products/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable("productId") Integer productId){
		   
		Product pro = productService.removeProduct(productId);
		
		return new ResponseEntity<>(pro,HttpStatus.OK);
	}
	
	
}
