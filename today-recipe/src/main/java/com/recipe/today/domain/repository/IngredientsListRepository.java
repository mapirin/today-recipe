package com.recipe.today.domain.repository;

import com.recipe.today.domain.entity.IngredientsListDTO;

public interface IngredientsListRepository {

	public int duplicateCheck(String recipeName);
	
	public void i(IngredientsListDTO ingredientsListDTO);
}
