package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
public class Category {
    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer catId;

	    @NotBlank(message = "Category Name is required")
	    private String categoryName;
	    
	    @NotBlank(message = "Description is required")
	    private String description;

	    @JsonIgnore
	    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	    private List<Product> products = new ArrayList<>();
	    
	    
	    
}
