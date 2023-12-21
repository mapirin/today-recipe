package com.recipe.today.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.recipe.today.domain.entity.ListDTO;
import com.recipe.today.domain.entity.RecipeListDTO;

@Mapper
public interface RecipeListRepository {

	public void i(RecipeListDTO recipeListDTO);
	
	public ListDTO s();
}
