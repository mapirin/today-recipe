package com.recipe.today.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.today.domain.entity.CommonMessageDTO;
import com.recipe.today.domain.entity.RecipeDataDTO;
import com.recipe.today.domain.model.RecipeDataForm;
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
	
	@Autowired
	private CommonMessageDTO commonMessageDTO;
	
	/**
	 * 入力されたレシピ名からレシピを検索する
	 * 
	 * @param recipeName
	 * @return
	 */
	@Transactional
	public RecipeDataForm selectRecipe(String recipeName) {
		RecipeDataForm recipeDataForm = new RecipeDataForm();
		RecipeDataDTO recipeDataDto = new RecipeDataDTO();
		recipeDataDto = recipeRepository.s(recipeName);
		
		//TODO recipeDataDtoをrecipeDataFormにセット
		BeanUtils.copyProperties(recipeDataForm, recipeDataDto);
		
		return recipeDataForm;
	}
	
	/**
	 * 入力された食材または調味料からレシピを検索する
	 * 
	 * @param name
	 * @return
	 */
	public RecipeDataForm selectRecipeForIngAndSeas(RecipeDataForm recipeDataForm) {
		RecipeDataForm recipeDataForm2 = new RecipeDataForm();
		//画面からはそれぞれのIDやキーをもらう想定
		//そこからIDに紐づく名称を取得し、レシピFormに突っ込んで返せばうまくいきそう
		return null;
	}
	
	/**
	 * 入力された１つまたは複数の気分からレシピを検索する
	 * 
	 * @param mood
	 * @return
	 */
	public RecipeDataForm selectRecipeForMood(String[] mood) {
		//いくつかの気分データをもとに取得処理を実行
		return null;
	}
	
	/**
	 * 何でもいいボタン押下時に実行
	 * ランダム生成された数値からレシピを検索する
	 * 
	 * @return
	 */
	public RecipeDataForm selectRecipeForRandom() {
		//まずはランダムな数値を生成
		//値はIDの形式であり、このランダムな数値をもとに取得処理を実行
		return null;
	}
}
