package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.model.Category;
import com.masai.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		if(category==null) throw new CategoryException("Null object");
		Optional<Category> opt = categoryRepository.findByCategoryName(category.getCategoryName());
		
		if(opt.isPresent()) {
			throw new CategoryException("Category already present in the database");
		}else {
			return categoryRepository.save(category);
		}
		
		
	}

	@Override
	public Category getCategory(Integer catId) {
		return categoryRepository.findById(catId).orElseThrow(()-> new CategoryException("No Category available with this id"));

	}

	@Override
	public List<Category> getAllCategory() {
		
		List<Category> categories = categoryRepository.findAll();
		
		return categories;
	}

	@Override
	public Category removeCategory(Integer catId) {
		 Optional<Category> opt = categoryRepository.findById(catId);
		   
		   if(opt.isPresent()) {
			  Category existingCategory = opt.get();
			  
			  categoryRepository.delete(existingCategory);
			  return existingCategory;
		   }
		   else
			  throw new CategoryException("Invalid Category  Id");
	}
  
}
