package com.recipe.today.domain.repository;

import com.recipe.today.domain.entity.IngredientsListDTO;
import com.recipe.today.domain.entity.ListDTO;

public interface IngredientsListRepository {

	public IngredientsListDTO i(ListDTO listDTO);
}
