package com.recipe.today.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.today.common.util.TodayRecipeUtil;
import com.recipe.today.domain.entity.IngredientsListDTO;
import com.recipe.today.domain.entity.RecipeListDTO;
import com.recipe.today.domain.entity.SeasoningListDTO;
import com.recipe.today.domain.model.ListForm;
import com.recipe.today.domain.repository.IngredientsListRepository;
import com.recipe.today.domain.repository.RecipeListRepository;
import com.recipe.today.domain.repository.SeasoningListRepository;

@Service
public class TodayRecipeService {

	@Autowired
	private RecipeListRepository recipeListRepository;

	@Autowired
	private IngredientsListRepository ingredientsListRepository;
	
	@Autowired
	private SeasoningListRepository seasoningListRepository;

	/**
	 * **serviceクラス登録処理**
	 * 
	 * 入力データを受け取る
	 * 受け取ったデータをDTOに格納する
	 * リストタイプごとに、受け取ったデータを引数にInsert処理を呼び出す
	 * 
	 * @param listForm 入力されたデータ
	 * @param listType 登録するデータのタイプ
	 * @return 処理結果
	 */
	@Transactional
	public boolean insertExec(ListForm listForm, int listType) {
		// 入力データを受け取りDTOに格納する
		switch(listType) {
			case TodayRecipeUtil.LIST_TYPE_RECIPE:
				RecipeListDTO recipeListDTO = storeRecipeListData(listForm);
				recipeListRepository.i(recipeListDTO);
				break;
			case TodayRecipeUtil.LIST_TYPE_INGREDIENTS:
				IngredientsListDTO ingredientsListDTO = storeIngredientsListData(listForm);
				ingredientsListRepository.i(ingredientsListDTO);
				break;
			case TodayRecipeUtil.LIST_TYPE_SEASONING:
				SeasoningListDTO seasoningListDTO = storeSeasoningListData(listForm);
				seasoningListRepository.i(seasoningListDTO);
				break;
			default:
				return false;
		}
		return true;
	}

	/**
	 * 受け取った入力値をレシピリストDTOに格納する
	 * 
	 * @param 入力レシピリスト
	 * @return 
	 */
	private RecipeListDTO storeRecipeListData(ListForm listForm) {
		RecipeListDTO recipeListDTO =  new RecipeListDTO();
		BeanUtils.copyProperties(listForm, recipeListDTO);
		return recipeListDTO;
	}
	
	/**
	 * 受け取った入力値を食材リストDTOに格納する
	 * 
	 * @param 入力調味料リスト
	 * @return 
	 */
	private IngredientsListDTO storeIngredientsListData(ListForm listForm) {
		IngredientsListDTO IngredientsListDTO = new IngredientsListDTO();
		BeanUtils.copyProperties(listForm, IngredientsListDTO);
		return IngredientsListDTO;
	}
	
	/**
	 * 受け取った入力値を調味料リストDTOに格納する
	 * 
	 * @param 入力調味料リスト
	 * @return 
	 */
	private SeasoningListDTO storeSeasoningListData(ListForm listForm) {
		SeasoningListDTO seasoningListDTO = new SeasoningListDTO();
		BeanUtils.copyProperties(listForm, seasoningListDTO);
		return seasoningListDTO;
	}
}
