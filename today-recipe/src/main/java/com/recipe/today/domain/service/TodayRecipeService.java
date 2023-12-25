package com.recipe.today.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.today.domain.entity.IngredientsListDTO;
import com.recipe.today.domain.entity.RecipeListDTO;
import com.recipe.today.domain.entity.SeasoningListDTO;
import com.recipe.today.domain.model.IngredientsListForm;
import com.recipe.today.domain.model.ListForm;
import com.recipe.today.domain.model.RecipeListForm;
import com.recipe.today.domain.repository.IngredientsListRepository;
import com.recipe.today.domain.repository.RecipeListRepository;
import com.recipe.today.domain.repository.SeasoningListRepository;

@Service
public class TodayRecipeService implements ListForm {

	@Autowired
	private RecipeListRepository recipeListRepository;

	@Autowired
	private IngredientsListRepository ingredientsListRepository;

	@Autowired
	private SeasoningListRepository seasoningListRepository;

	/**
	 * **serviceクラス登録処理**
	 * 
	 * 入力データを受け取る 受け取ったデータをDTOに格納する リストタイプごとに、受け取ったデータを引数にInsert処理を呼び出す
	 * 
	 * @param listForm 入力されたデータ
	 * @param listType 登録するデータのタイプ
	 * @return 処理結果
	 */
	@Transactional
	public boolean insertExec(ListForm listForm, int listType) {
//		// 入力データを受け取りDTOに格納する
//		switch (listType) {
//		case TodayRecipeUtil.LIST_TYPE_RECIPE:
//			RecipeListDTO recipeListDTO = storeRecipeListData(listForm);
//			recipeListRepository.i(recipeListDTO);
//			break;
//		case TodayRecipeUtil.LIST_TYPE_INGREDIENTS:
//			IngredientsListDTO ingredientsListDTO = storeIngredientsListData(listForm);
//			ingredientsListRepository.i(ingredientsListDTO);
//			break;
//		case TodayRecipeUtil.LIST_TYPE_SEASONING:
//			SeasoningListDTO seasoningListDTO = storeSeasoningListData(listForm);
//			seasoningListRepository.i(seasoningListDTO);
//			break;
//		default:
//			return false;
//		}
		return true;
	}

	/**
	 * **serviceクラス登録処理**
	 * 
	 * 入力データを受け取る 受け取ったデータをDTOに格納する リストタイプごとに、受け取ったデータを引数にInsert処理を呼び出す
	 * 
	 * @param listForm 入力されたデータ
	 * @param listType 登録するデータのタイプ
	 * @return 処理結果
	 */
	@Transactional
	public boolean insertRecipeExec(RecipeListForm recipeListForm) {
		// 入力データを受け取りDTOに格納する
		try {
			RecipeListDTO recipeListDTO = storeRecipeListData(recipeListForm);
			recipeListRepository.i(recipeListDTO);
		} catch (Exception e) {
			return false;
		} finally {
		}
		return true;
	}
	
	/**
	 * **serviceクラス登録処理**
	 * 
	 * 入力データを受け取る 受け取ったデータをDTOに格納する リストタイプごとに、受け取ったデータを引数にInsert処理を呼び出す
	 * 
	 * @param listForm 入力されたデータ
	 * @param listType 登録するデータのタイプ
	 * @return 処理結果
	 */
	@Transactional
	public boolean insertIngredientsExec(IngredientsListForm ingredientsListForm) {
		// 入力データを受け取りDTOに格納する
		try {
			IngredientsListDTO IngredientsListDTO = storeIngredientsListData(ingredientsListForm);
			recipeListRepository.i(ingredientsListForm);
		} catch (Exception e) {
			return false;
		} finally {
		}
		return true;
	}

	/**
	 * 受け取った入力値をレシピリストDTOに格納する
	 * 
	 * @param 入力レシピリスト
	 * @return
	 */
	private RecipeListDTO storeRecipeListData(RecipeListForm recipeListForm) {
		RecipeListDTO recipeListDTO = new RecipeListDTO();

		recipeListDTO.setRecipeName(recipeListForm.getRecipeName());
		recipeListDTO.setIngredientsId1(recipeListForm.getIngredientsId1());
		recipeListDTO.setIngredientsId2(recipeListForm.getIngredientsId2());
		recipeListDTO.setIngredientsId3(recipeListForm.getIngredientsId3());
		recipeListDTO.setIngredientsId4(recipeListForm.getIngredientsId4());
		recipeListDTO.setIngredientsId5(recipeListForm.getIngredientsId5());
		recipeListDTO.setIngredientsId6(recipeListForm.getIngredientsId6());
		recipeListDTO.setIngredientsId7(recipeListForm.getIngredientsId7());
		recipeListDTO.setIngredientsId8(recipeListForm.getIngredientsId8());
		recipeListDTO.setIngredientsId9(recipeListForm.getIngredientsId9());
		recipeListDTO.setIngredientsId10(recipeListForm.getIngredientsId10());
		recipeListDTO.setIngredientsId11(recipeListForm.getIngredientsId11());
		recipeListDTO.setIngredientsId12(recipeListForm.getIngredientsId12());
		recipeListDTO.setIngredientsId13(recipeListForm.getIngredientsId13());
		recipeListDTO.setIngredientsId14(recipeListForm.getIngredientsId14());
		recipeListDTO.setIngredientsId15(recipeListForm.getIngredientsId15());
		recipeListDTO.setIngredientsId16(recipeListForm.getIngredientsId16());
		recipeListDTO.setIngredientsId17(recipeListForm.getIngredientsId17());
		recipeListDTO.setIngredientsId18(recipeListForm.getIngredientsId18());
		recipeListDTO.setIngredientsId19(recipeListForm.getIngredientsId19());
		recipeListDTO.setIngredientsId20(recipeListForm.getIngredientsId20());
		recipeListDTO.setSeasoningId1(recipeListForm.getSeasoningId1());
		recipeListDTO.setSeasoningId2(recipeListForm.getSeasoningId2());
		recipeListDTO.setSeasoningId3(recipeListForm.getSeasoningId3());
		recipeListDTO.setSeasoningId4(recipeListForm.getSeasoningId4());
		recipeListDTO.setSeasoningId5(recipeListForm.getSeasoningId5());
		recipeListDTO.setSeasoningId6(recipeListForm.getSeasoningId6());
		recipeListDTO.setSeasoningId7(recipeListForm.getSeasoningId7());
		recipeListDTO.setSeasoningId8(recipeListForm.getSeasoningId8());
		recipeListDTO.setSeasoningId9(recipeListForm.getSeasoningId9());
		recipeListDTO.setSeasoningId10(recipeListForm.getSeasoningId10());
		recipeListDTO.setSeasoningId11(recipeListForm.getSeasoningId11());
		recipeListDTO.setSeasoningId12(recipeListForm.getSeasoningId12());
		recipeListDTO.setSeasoningId13(recipeListForm.getSeasoningId13());
		recipeListDTO.setSeasoningId14(recipeListForm.getSeasoningId14());
		recipeListDTO.setSeasoningId15(recipeListForm.getSeasoningId15());
		recipeListDTO.setSeasoningId16(recipeListForm.getSeasoningId16());
		recipeListDTO.setSeasoningId17(recipeListForm.getSeasoningId17());
		recipeListDTO.setSeasoningId18(recipeListForm.getSeasoningId18());
		recipeListDTO.setSeasoningId19(recipeListForm.getSeasoningId19());
		recipeListDTO.setSeasoningId20(recipeListForm.getSeasoningId20());
		recipeListDTO.setRecipeTimeRequired(recipeListForm.getRecipeTimeRequired());
		recipeListDTO.setRecipeMethod1(recipeListForm.getRecipeMethod1());
		recipeListDTO.setRecipeMethod2(recipeListForm.getRecipeMethod2());
		recipeListDTO.setRecipeMethod3(recipeListForm.getRecipeMethod3());
		recipeListDTO.setRecipeMethod4(recipeListForm.getRecipeMethod4());
		recipeListDTO.setRecipeMethod5(recipeListForm.getRecipeMethod5());
		recipeListDTO.setRecipeMethod6(recipeListForm.getRecipeMethod6());
		recipeListDTO.setRecipeMethod7(recipeListForm.getRecipeMethod7());
		recipeListDTO.setRecipeMethod8(recipeListForm.getRecipeMethod8());
		recipeListDTO.setRecipeMethod9(recipeListForm.getRecipeMethod9());
		recipeListDTO.setRecipeMethod10(recipeListForm.getRecipeMethod10());

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
