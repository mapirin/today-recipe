package com.recipe.today.domain.repository;

import com.recipe.today.domain.entity.IngredientsMasterDTO;

public interface IngredientsRepository {

	public int duplicateCheck(String recipeName);
	
	public void i(IngredientsMasterDTO ingredientsMasterDTO);
}
