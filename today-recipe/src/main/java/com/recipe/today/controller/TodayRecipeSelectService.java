package com.recipe.today.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.today.domain.entity.RecipeListDTO;
import com.recipe.today.domain.repository.IngredientsListRepository;
import com.recipe.today.domain.repository.RecipeListRepository;
import com.recipe.today.domain.repository.SeasoningListRepository;

@Service
public class TodayRecipeSelectService {

	@Autowired
	private RecipeListRepository recipeListRepository;

	@Autowired
	private IngredientsListRepository ingredientsListRepository;

	@Autowired
	private SeasoningListRepository seasoningListRepository;
	
	/**
	 * 受け取ったレシピ名からリクエストするレシピDTOを取得する
	 * 
	 * @param 入力されたレシピ名
	 * @return 
	 */
	public RecipeListDTO findRecipe(String recipeName) {
		RecipeListDTO recipeListDTO = recipeListRepository.s(recipeName);
		
		return recipeListDTO;
	}
	
	/**
	 * 受け取ったレシピDTOに対して食材＆調味料名を取得する
	 * 
	 * @param 入力されたレシピ名
	 * @return 
	 */
	// TODO 食材IDと食材名（調味料も同様）をどう紐づけるか
	private RecipeListDTO findRecipe(RecipeListDTO recipeListDTO) {
		RecipeListDTO recipeListDTO2 = recipeListRepository.s(recipeListDTO.getRecipeName());
		
		return recipeListDTO;
	}
	
}
