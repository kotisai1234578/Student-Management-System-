package com.masai.service;

import java.util.List;

import com.masai.model.Category;

public interface CategoryService {
   
	public Category addCategory(Category category);
	
	public Category getCategory(Integer catId);
	
	public List<Category> getAllCategory();
	
	public Category removeCategory(Integer catId);
}
