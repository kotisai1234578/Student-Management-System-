package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>, PagingAndSortingRepository<Category,Integer>{
  
	
	public Optional<Category> findByCategoryName(String name);
}
