package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Category;
import com.masai.service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {
    
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("Categories")
	public ResponseEntity<Category> addNewCategory(@RequestBody @Valid Category category){
		   
		Category cat = categoryService.addCategory(category);
		
		return new ResponseEntity<>(cat,HttpStatus.CREATED);
	}
	
	@GetMapping("Categories/{categoryId}")
	public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Integer categoryId){
		   
		Category cat = categoryService.getCategory(categoryId);
		
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	

	@GetMapping("Categories")
	public ResponseEntity<List<Category>> getAllCategory(){
		   
		List<Category> cat = categoryService.getAllCategory();
		
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	

	@DeleteMapping("Categories/{categoryId}")
	public ResponseEntity<Category> deleteCategory(@PathVariable("categoryId") Integer categoryId){
		   
		Category cat = categoryService.removeCategory(categoryId);
		
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
}
