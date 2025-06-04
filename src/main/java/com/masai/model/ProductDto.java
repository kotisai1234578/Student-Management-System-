package com.masai.model;

import java.util.Locale.Category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	    @NotNull(message = "Price is required")
	    @Positive(message = "Price must be positive")
	    private Double price;
	    
	    @Positive(message = "Rating must be positive")
	    private Double rating;
}
