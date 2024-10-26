package com.recipe.today.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.today.domain.entity.RecipeDataDTO;
import com.recipe.today.domain.repository.IngredientsRepository;
import com.recipe.today.domain.repository.RecipeRepository;
import com.recipe.today.domain.repository.SeasoningRepository;

@Service
public class TodayRecipeSelectService {

	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private IngredientsRepository ingredientsRepository;

	@Autowired
	private SeasoningRepository seasoningRepository;
	
	/**
	 * 受け取ったレシピ名からリクエストするレシピDTOを取得する
	 * 
	 * @param 入力されたレシピ名
	 * @return 
	 */
	public RecipeDataDTO findRecipe(String recipeName) {
		RecipeDataDTO recipeDataDTO = recipeRepository.s(recipeName);
		
		return recipeDataDTO;
	}
	
	/**
	 * 受け取ったレシピDTOに対して食材＆調味料名を取得する
	 * 
	 * @param 入力されたレシピ名
	 * @return 
	 */
	// TODO 食材IDと食材名（調味料も同様）をどう紐づけるか
	private RecipeDataDTO findRecipe(RecipeDataDTO recipeDataDTO) {
		RecipeDataDTO recipeListDTO2 = recipeRepository.s(recipeDataDTO.getRecipeName());
		
		return recipeDataDTO;
	}
	
}
