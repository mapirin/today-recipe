package com.recipe.today.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.today.domain.entity.CommonMessageDTO;
import com.recipe.today.domain.entity.IngredientsListDTO;
import com.recipe.today.domain.entity.RecipeListDTO;
import com.recipe.today.domain.entity.SeasoningListDTO;
import com.recipe.today.domain.model.IngredientsListForm;
import com.recipe.today.domain.model.RecipeListForm;
import com.recipe.today.domain.model.SeasoningListForm;
import com.recipe.today.domain.repository.IngredientsListRepository;
import com.recipe.today.domain.repository.RecipeListRepository;
import com.recipe.today.domain.repository.SeasoningListRepository;

@Service
public class TodayRecipeRegistService{

	@Autowired
	private RecipeListRepository recipeListRepository;

	@Autowired
	private IngredientsListRepository ingredientsListRepository;

	@Autowired
	private SeasoningListRepository seasoningListRepository;
	
	@Autowired
	private CommonMessageDTO commonMessageDTO;

	/**
	 * **serviceクラス登録処理（レシピ）**
	 * 
	 * 入力データを受け取る 受け取ったデータをDTOに格納する 受け取ったデータを引数にInsert処理を呼び出す
	 * 
	 * @param listForm 入力されたデータ
	 * @param listType 登録するデータのタイプ
	 * @return 処理結果
	 */
	@Transactional
	public CommonMessageDTO insertRecipeExec(RecipeListForm recipeListForm, String id){
		// 入力データを受け取りDTOに格納する
		RecipeListDTO recipeListDTO = storeRecipeListData(recipeListForm);
		
		try {
			// レシピ名の重複チェックを実行する
			String message = duplicateCheck(recipeListDTO.getRecipeName(), id);
			if(message.equals("")) {
				commonMessageDTO.setMessage("");
				commonMessageDTO.setResult(true);
				return commonMessageDTO;
			}
			// 登録実行
			recipeListRepository.i(recipeListDTO);
			
		} catch (Exception e) {
			commonMessageDTO.setMessage("");
			commonMessageDTO.setResult(false);
			return commonMessageDTO;
		} finally {
		}
		commonMessageDTO.setMessage("");
		commonMessageDTO.setResult(true);
		return commonMessageDTO;
	}
	
	/**
	 * **serviceクラス登録処理（食材）**
	 * 
	 * 入力データを受け取る 受け取ったデータをDTOに格納する 受け取ったデータを引数にInsert処理を呼び出す
	 * 
	 * @param listForm 入力されたデータ
	 * @param listType 登録するデータのタイプ
	 * @return 処理結果
	 */
	@Transactional
	public CommonMessageDTO insertIngredientsExec(IngredientsListForm ingredientsListForm, String id) {
		// 入力データを受け取りDTOに格納する
		IngredientsListDTO ingredientsListDTO = storeIngredientsListData(ingredientsListForm);
		
		try {
		// レシピ名の重複チェックを実行する
			String message = duplicateCheck(ingredientsListDTO.getIngredientsName(), id);
			if(message.equals("")) {
				commonMessageDTO.setMessage("");
				commonMessageDTO.setResult(true);
				return commonMessageDTO;
			}
			// 登録実行
			ingredientsListRepository.i(ingredientsListDTO);
			
		} catch (Exception e) {
			commonMessageDTO.setMessage("");
			commonMessageDTO.setResult(false);
			return commonMessageDTO;
		} finally {
		}
		commonMessageDTO.setMessage("");
		commonMessageDTO.setResult(true);
		return commonMessageDTO;
	}
	
	/**
	 * **serviceクラス登録処理（調味料）**
	 * 
	 * 入力データを受け取る 受け取ったデータをDTOに格納する 受け取ったデータを引数にInsert処理を呼び出す
	 * 
	 * @param listForm 入力されたデータ
	 * @param listType 登録するデータのタイプ
	 * @return 処理結果
	 */
	@Transactional
	public CommonMessageDTO insertSeasoningExec(SeasoningListForm seasoningListForm, String id) {
		// 入力データを受け取りDTOに格納する
		SeasoningListDTO seasoningListDTO = storeSeasoningListData(seasoningListForm);
				
		try {
		// レシピ名の重複チェックを実行する
			String message = duplicateCheck(seasoningListDTO.getSeasoningName(), id);
			if(message.equals("")) {
				commonMessageDTO.setMessage("");
				commonMessageDTO.setResult(true);
				return commonMessageDTO;
			}
			// 登録実行
			seasoningListRepository.i(seasoningListDTO);
			
		} catch (Exception e) {
			commonMessageDTO.setMessage("");
			commonMessageDTO.setResult(false);
			return commonMessageDTO;
		} finally {
		}
		commonMessageDTO.setMessage("");
		commonMessageDTO.setResult(true);
		return commonMessageDTO;
	}

	/**
	 * 受け取った入力値をレシピリストDTOに格納する
	 * 
	 * @param 入力レシピリスト
	 * @return レシピリストDTO
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
	 * @return 食材リストDTO
	 */
	private IngredientsListDTO storeIngredientsListData(IngredientsListForm ingredientsListForm) {
		IngredientsListDTO ingredientsListDTO = new IngredientsListDTO();
		
		ingredientsListDTO.setIngredientsName(ingredientsListForm.getIngredientsName());
		ingredientsListDTO.setIngredientsType(ingredientsListForm.getIngredientsType());
		ingredientsListDTO.setIngredientsPriority(ingredientsListForm.getIngredientsPriority());
		ingredientsListDTO.setIngredientsPicPath(ingredientsListForm.getIngredientsPicPath());
		
		return ingredientsListDTO;
	}

	/**
	 * 受け取った入力値を調味料リストDTOに格納する
	 * 
	 * @param 入力調味料リスト
	 * @return 調味料リストDTO
	 */
	private SeasoningListDTO storeSeasoningListData(SeasoningListForm seasoningListForm) {
		SeasoningListDTO seasoningListDTO = new SeasoningListDTO();
		
		seasoningListDTO.setSeasoningName(seasoningListForm.getSeasoningName());
		seasoningListDTO.setSeasoningType(seasoningListForm.getSeasoningType());
		seasoningListDTO.setSeasoningPriority(seasoningListForm.getSeasoningPriority());
		seasoningListDTO.setSeasoningPicPath(seasoningListForm.getSeasoningPicPath());
		
		return seasoningListDTO;
	}
	
	/**
	 * 受け取った各名称と種別IDをもとに、対応するTBLからデータを取得する
	 * 
	 * @param 入力された名称
	 * @return 処理結果メッセージ
	 */
	public String duplicateCheck(String ｎame, String id)throws Exception {
		
		// messages.propertiesから対象メッセージを取得
		String message = "";
		
		try {
			int count = 0;
			
			switch (id) {
			case "1":
				count = recipeListRepository.duplicateCheck(ｎame);
				if(count > 0) {
					return message = "";
				}
				break;
			case "2":
				count = ingredientsListRepository.duplicateCheck(ｎame);
				if(count > 0) {
					return message = "";
				}
				break;
			case "3":
				count = seasoningListRepository.duplicateCheck(ｎame);
				if(count > 0) {
					return message = "";
				}
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return message = "";
	}
	
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
