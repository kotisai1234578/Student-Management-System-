package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CategoryException;
import com.masai.model.Category;
import com.masai.model.Product;
import com.masai.repository.CategoryRepository;
import com.masai.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	 @Autowired
	 private CategoryRepository categoryRepository;
	 
	 @Autowired
	 private ProductRepository productRepository;

	@Override
	public Product addProductToCategory(Integer catId, Integer productId) {
	    
        Optional<Category> optionalCategory = categoryRepository.findById(catId);
        Optional<Product> optionalProduct = productRepository.findById(productId);

        // Check if both Category and Product exist
        if (optionalCategory.isPresent() && optionalProduct.isPresent()) {
            Category category = optionalCategory.get();
            Product product = optionalProduct.get();

            // Associate the Product with the Category
             List<Product> products =category.getProducts();
             products.add(product);
             
             // set Category on produt maintaining bidirectional relationship
             product.setCategory(category);
             
             categoryRepository.save(category);
             
             return productRepository.save(product);
           
        } else {
          
            throw new EntityNotFoundException("Category or Product not found");
        }
	}

	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		  Optional<Category> optionalCategory = categoryRepository.findByCategoryName(categoryName);

		    if (optionalCategory.isPresent()) {
		        Category category = optionalCategory.get();
		        return category.getProducts();
		    } else {
		       
		        throw new CategoryException("Category not found");
		    }
	}

	@Override
	public Product removeProductFromCategory(Integer catId, Integer productId) {
		   Optional<Category> optionalCategory = categoryRepository.findById(catId);
		    Optional<Product> optionalProduct = productRepository.findById(productId);

		   
		    if (optionalCategory.isPresent() && optionalProduct.isPresent()) {
		        Category category = optionalCategory.get();
		        Product product = optionalProduct.get();

		        // Disassociate the Product from the Category
		        List<Product> products = category.getProducts();
		        products.remove(product);

		        // Clear the reference to the Category on the Product (maintaining bidirectional relationship)
		        product.setCategory(null);

		        // Save the updated entities
		        categoryRepository.save(category);
		        Product updatedProduct = productRepository.save(product);

		        return updatedProduct;
		    } else {
		        
		        throw new CategoryException("Category or Product not found");
		    }
	}
   
}
