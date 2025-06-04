package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Product;
import com.masai.service.ProductCategoryService;

@RestController
public class ProductCategoryController {
   
	@Autowired
	private ProductCategoryService productCategoryService;
	

	@PostMapping("Categories/{categoryId}/products/{productId}")
	public ResponseEntity<Product> getproducttoCategory(@PathVariable("categoryId") Integer categoryId, @PathVariable("productId") Integer productId){
       
		Product pro = productCategoryService.addProductToCategory(categoryId, productId);
		
		return new ResponseEntity<>(pro,HttpStatus.CREATED);
	}
	
	@GetMapping("Categories/products/{categoryName}")
	public ResponseEntity<List<Product>> getallproductsofCategory(@PathVariable("categoryName") String categoryName){
       
		List<Product> pro = productCategoryService.getProductsByCategory(categoryName);
		
		return new ResponseEntity<>(pro,HttpStatus.OK);
	}
	
	@DeleteMapping("Categories/{categoryId}/products/{productId}")
	public ResponseEntity<Product> removeproductfromcategory(@PathVariable("categoryId") Integer categoryId, @PathVariable("productId") Integer productId){
       
		Product pro = productCategoryService.removeProductFromCategory(categoryId, productId);
		
		return new ResponseEntity<>(pro,HttpStatus.OK);
	}
	
	
}
