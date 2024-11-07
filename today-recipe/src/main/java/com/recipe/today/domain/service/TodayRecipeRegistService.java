package com.recipe.today.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.today.domain.entity.CommonMessageDTO;
import com.recipe.today.domain.entity.IngredientsDataDTO;
import com.recipe.today.domain.entity.IngredientsMasterDTO;
import com.recipe.today.domain.entity.RecipeDataDTO;
import com.recipe.today.domain.entity.SeasoningDataDTO;
import com.recipe.today.domain.entity.SeasoningMasterDTO;
import com.recipe.today.domain.model.IngredientsMasterForm;
import com.recipe.today.domain.model.RecipeDataForm;
import com.recipe.today.domain.model.SeasoningMasterForm;
import com.recipe.today.domain.repository.IngredientsRepository;
import com.recipe.today.domain.repository.TodayRecipeSelectRepository;
import com.recipe.today.domain.repository.SeasoningRepository;

@Service
public class TodayRecipeRegistService{

	@Autowired
	private TodayRecipeSelectRepository todayRecipeSelectRepository;

	@Autowired
	private IngredientsRepository ingredientsRepository;

	@Autowired
	private SeasoningRepository seasoningRepository;
	
	@Autowired
	private CommonMessageDTO commonMessageDTO;

	/**
	 * **serviceクラス登録処理（レシピ）**
	 * 
	 * 入力データを受け取る 受け取ったデータを各DTOに格納する DTOを引数にInsert処理を呼び出す
	 * 
	 * @param listForm 入力されたデータ
	 * @param listType 登録するデータのタイプ
	 * @return 処理結果
	 */
	@Transactional
	public CommonMessageDTO insertRecipeExec(RecipeDataForm recipeDataForm, String dataType){
		//TODO 入力データのうち、食材にかかわるデータを食材データDTOに格納する
		IngredientsDataDTO ingredientsDataDTO = 
				storeIngredientsData(
						recipeDataForm.getIngredientsKey()
						,recipeDataForm.getIngredientsId()
						,recipeDataForm.getRecipeTypeId()
						,recipeDataForm.getIngredientsOrder());
		//TODO 入力データのうち、調味料にかかわるデータを調味料データDTOに格納する
		SeasoningDataDTO seasoningDataDTO = 
				storeSeasoningData(
						recipeDataForm.getSeasoningKey()
						,recipeDataForm.getSeasoningId()
						,recipeDataForm.getRecipeTypeId()
						,recipeDataForm.getSeasoningOrder());
		// 入力データを、レシピデータDTOに格納する
		RecipeDataDTO recipeDataDTO = storeRecipeData(recipeDataForm);
		
		try {
			// レシピ名の重複チェックを実行する
			String message = duplicateCheck(recipeDataDTO.getRecipeName(), dataType);
			if(message.equals("")) {
				commonMessageDTO.setMessage("");
				commonMessageDTO.setResult(true);
				return commonMessageDTO;
			}
			// 登録実行
			ingredientsRepository.i(ingredientsDataDTO);
			seasoningRepository.i(seasoningDataDTO);
			todayRecipeSelectRepository.i(recipeDataDTO);
			
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
	 * 入力データを受け取る 受け取ったデータをDTOに格納する DTOを引数にInsert処理を呼び出す
	 * 
	 * @param listForm 入力されたデータ
	 * @param listType 登録するデータのタイプ
	 * @return 処理結果
	 */
	@Transactional
	public CommonMessageDTO insertIngredientsExec(IngredientsMasterForm ingredientsMasterForm, String listType) {
		// 入力データを受け取りDTOに格納する
		IngredientsMasterDTO ingredientsMasterDTO = storeIngredientsMasterData(ingredientsMasterForm);
		
		try {
		// 食材名の重複チェックを実行する
			String message = duplicateCheck(ingredientsMasterDTO.getIngredientsName(), listType);
			if(message.equals("")) {
				commonMessageDTO.setMessage("");
				commonMessageDTO.setResult(true);
				return commonMessageDTO;
			}
			// 登録実行
			ingredientsRepository.i(ingredientsMasterDTO);
			
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
	 * 入力データを受け取る 受け取ったデータをDTOに格納する DTOを引数にInsert処理を呼び出す
	 * 
	 * @param listForm 入力されたデータ
	 * @param listType 登録するデータのタイプ
	 * @return 処理結果
	 */
	@Transactional
	public CommonMessageDTO insertSeasoningExec(SeasoningMasterForm seasoningMasterForm, String listType) {
		// 入力データを受け取りDTOに格納する
		SeasoningMasterDTO seasoningMasteraDTO = storeSeasoningMasterData(seasoningMasterForm);
				
		try {
		// レシピ名の重複チェックを実行する
			String message = duplicateCheck(seasoningMasteraDTO.getSeasoningName(), listType);
			if(message.equals("")) {
				commonMessageDTO.setMessage("");
				commonMessageDTO.setResult(true);
				return commonMessageDTO;
			}
			// 登録実行
			seasoningRepository.i(seasoningMasteraDTO);
			
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
	 * 受け取った入力値を食材データDTOに格納する
	 * 
	 * @param 食材データ
	 * @return 食材データDTO
	 */
	private IngredientsDataDTO storeIngredientsData(String key, int id, int typeId, String order) {
		IngredientsDataDTO ingredientsDataDTO = new IngredientsDataDTO();
		
		ingredientsDataDTO.setIngredientsKey(key);
		ingredientsDataDTO.setIngredientsId(id);
		ingredientsDataDTO.setIngredientsTypeId(typeId);
		ingredientsDataDTO.setIngredientsOrder(order);
		
		return ingredientsDataDTO;
	}

	/**
	 * 受け取った入力値を調味料データDTOに格納する
	 * 
	 * @param 調味料データ
	 * @return 調味料データDTO
	 */
	private SeasoningDataDTO storeSeasoningData(String key, int id, int typeId, String order) {
		SeasoningDataDTO seasoningDataDTO = new SeasoningDataDTO();
		
		seasoningDataDTO.setSeasoningKey(key);
		seasoningDataDTO.setSeasoningId(id);
		seasoningDataDTO.setSeasoningTypeId(typeId);
		seasoningDataDTO.setSeasoningOrder(order);
		
		return seasoningDataDTO;
	}
	
	/**
	 * 受け取った入力値をレシピデータDTOに格納する
	 * 
	 * @param 入力レシピ
	 * @return レシピデータDTO
	 */
	private RecipeDataDTO storeRecipeData(RecipeDataForm RecipeDataForm) {
		RecipeDataDTO recipeDataDTO = new RecipeDataDTO();
		
		// 入力値
		recipeDataDTO.setRecipeName(RecipeDataForm.getRecipeName());
		// 取得または採番値
		recipeDataDTO.setIngredientsKey(RecipeDataForm.getIngredientsKey());
		// 取得値
		recipeDataDTO.setIngredientsId(RecipeDataForm.getIngredientsId());
		//TODO  
		recipeDataDTO.setIngredientsOrder(RecipeDataForm.getIngredientsOrder());
		// 取得または採番値
		recipeDataDTO.setSeasoningKey(RecipeDataForm.getSeasoningKey());
		// 取得値
		recipeDataDTO.setSeasoningId(RecipeDataForm.getSeasoningId());
		//TODO 
		recipeDataDTO.setSeasoningOrder(RecipeDataForm.getSeasoningOrder());
		// 取得または採番値
		recipeDataDTO.setProcessKey(RecipeDataForm.getProcessKey());
		// 入力値
		recipeDataDTO.setProcess(RecipeDataForm.getProcess());
		// 入力値
		recipeDataDTO.setCookingTime(RecipeDataForm.getCookingTime());
		// 取得または採番値
		recipeDataDTO.setMoodKey(RecipeDataForm.getMoodKey());
		// 取得値
		recipeDataDTO.setMoodId(RecipeDataForm.getMoodId());
		// 取得値
		recipeDataDTO.setRecipeTypeId(RecipeDataForm.getRecipeTypeId());

		return recipeDataDTO;
	}

	/**
	 * 受け取った入力値を食材マスタDTOに格納する
	 * 
	 * @param 食材マスタデータ
	 * @return 食材マスタDTO
	 */
	private IngredientsMasterDTO storeIngredientsMasterData(IngredientsMasterForm ingredientsMasterForm) {
		IngredientsMasterDTO ingredientsMasterDTO = new IngredientsMasterDTO();
		
		ingredientsMasterDTO.setIngredientsId(ingredientsMasterForm.getIngredientsId());
		ingredientsMasterDTO.setIngredientsName(ingredientsMasterForm.getIngredientsName());
		ingredientsMasterDTO.setIngredientsPicPath(ingredientsMasterForm.getIngredientsPicPath());
		
		return ingredientsMasterDTO;
	}

	/**
	 * 受け取った入力値を調味料マスタDTOに格納する
	 * 
	 * @param 調味料マスタデータ
	 * @return 調味料マスタDTO
	 */
	private SeasoningMasterDTO storeSeasoningMasterData(SeasoningMasterForm seasoningMasterForm) {
		SeasoningMasterDTO seasoningMasterDTO = new SeasoningMasterDTO();
		
		seasoningMasterDTO.setSeasoningId(seasoningMasterForm.getSeasoningId());
		seasoningMasterDTO.setSeasoningName(seasoningMasterForm.getSeasoningName());
		seasoningMasterDTO.setSeasoningPicPath(seasoningMasterForm.getSeasoningPicPath());
		
		return seasoningMasterDTO;
	}
	
	/**
	 * 受け取った各名称と種別IDをもとに、対応するTBLからデータを取得する
	 * 
	 * @param 入力された名称
	 * @return 処理結果メッセージ
	 */
	@Transactional
	public String duplicateCheck(String ｎame, String id)throws Exception {
		
		// messages.propertiesから対象メッセージを取得
		String message = "";
		
		try {
			int count = 0;
			
			switch (id) {
			case "1":
				count = todayRecipeSelectRepository.duplicateCheck(ｎame);
				if(count > 0) {
					return message = "";
				}
				break;
			case "2":
				count = ingredientsRepository.duplicateCheck(ｎame);
				if(count > 0) {
					return message = "";
				}
				break;
			case "3":
				count = seasoningRepository.duplicateCheck(ｎame);
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
	
//	/**
//	 * 受け取ったレシピ名からリクエストするレシピDTOを取得する
//	 * 
//	 * @param 入力されたレシピ名
//	 * @return 
//	 */
//	@Transactional
//	public RecipeDataDTO findRecipe(String recipeName) {
//		RecipeDataDTO recipeDataDTO = recipeRepository.s(recipeName);
//		
//		return recipeDataDTO;
//	}
	
//	/**
//	 * 受け取ったレシピDTOに対して食材＆調味料名を取得する
//	 * 
//	 * @param 入力されたレシピ名
//	 * @return 
//	 */
//	// TODO 食材IDと食材名（調味料も同様）をどう紐づけるか
//	@Transactional
//	private RecipeDataDTO findRecipe(RecipeDataDTO recipeDataDTO) {
//		RecipeDataDTO recipeListDTO = recipeRepository.s(recipeDataDTO.getRecipeName());
//		
//		return recipeDataDTO;
//	}
}
