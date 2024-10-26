package com.recipe.today.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.recipe.today.domain.entity.RecipeDataDTO;

@Mapper
public interface RecipeRepository {

	public void i(RecipeDataDTO recipeDataDTO);
	
	public int duplicateCheck(String recipeName);
	
	public RecipeDataDTO s(String recipeName);
}
