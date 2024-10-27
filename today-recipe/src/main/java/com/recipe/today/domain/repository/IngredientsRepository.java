package com.recipe.today.domain.repository;

import com.recipe.today.domain.entity.ListDTO;

public interface IngredientsRepository {

	public int duplicateCheck(String recipeName);
	
	public void i(ListDTO listDTO);
}
