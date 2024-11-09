package com.recipe.today.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.recipe.today.domain.entity.CommonMessageDTO;
import com.recipe.today.domain.model.IngredientsMasterForm;
import com.recipe.today.domain.model.RecipeDataForm;
import com.recipe.today.domain.model.SeasoningMasterForm;
import com.recipe.today.domain.service.TodayRecipeRegistService;
import com.recipe.today.domain.service.TodayRecipeSelectService;

@RestController
@SessionAttributes({ "recipeDataForm", "ingredientsMasterForm", "seaosoningMasterForm" })
public class TodayRecipeController {

	@Autowired
	private TodayRecipeRegistService todayRecipeRegistService;

	@Autowired
	private TodayRecipeSelectService todayRecipeSelectService;

	@Autowired
	private CommonMessageDTO commonMessageDTO;

	@ModelAttribute
	public RecipeDataForm recipeDataForm() {
		return new RecipeDataForm();
	}

	@ModelAttribute
	public IngredientsMasterForm ingredientsMasterForm() {
		return new IngredientsMasterForm();
	}

	@ModelAttribute
	public SeasoningMasterForm seaosoningMasterForm() {
		return new SeasoningMasterForm();
	}

	// メニュー
	@GetMapping("/")
	public String menu() {
		return "recipe/today/todayRecipeMenu";
	}

	/** 選択画面 **/
	// メニュー→選択画面
	@PostMapping(value = "/today-recipe-recipe-select", params = "success")
	public String menuToRecipeSelect() {
		return "recipe/today/select/todayRecipeSelect";
	}

	// 選択画面で検索処理
	/** @ModelAttribute("recipeDataForm")は明示的な指定が不要になったらしい  **/
	@PostMapping(value = "/recipe-name-select", params = "recipeSelect_btn")
	public String selectRecipeForName(String recipeName,
			RecipeDataForm recipeDataForm, Model model) {
		// 検索処理実行
		RecipeDataForm recipeData = todayRecipeSelectService.selectRecipeForName(recipeName);
		
		// 検索処理結果を画面に返却
		if (commonMessageDTO.isResult()) {
			model.addAttribute("recipeData", recipeData);
			return "redirect:/today-recipe-select?success";
		}
		return "recipe/today/select/todayRecipeSelect";
	}

//	/** 登録画面に遷移 **/
//	// レシピ登録
//	// メニュー→レシピ登録画面
//	@PostMapping(value = "/menu", params = "regist_start_btn")
//	public String menuToRecipeRegist() {
//		return "recipe/today/register/todayRecipeRegist";
//	}
//
//	// 食材登録
//	// メニュー→食材登録
//	@PostMapping(value = "/regist", params = "ingredientsChange_btn")
//	public String recepiRegistToIngredientsRegist() {
//		
//		return "recipe/today/register/todayRecipeIngredientsRegist";
//	}
//	
//	// 調味料登録
//	// メニュー→調味料登録
//	@PostMapping(value = "/ingredientsRegist", params = "seasoningChange_btn")
//	public String recepiRegistToSeasoningRegist() {
//		
//		return "recipe/today/register/todayRecipeSeasoningRegist";
//	}
//	// 調味料登録
//	// 調味料登録→食材登録
//	@PostMapping(value = "/seasoningRegist", params = "ingredientsChange_btn")
//	public String seasoningRegistToRecepiRegist() {
//		
//		return "recipe/today/register/todayRecipeIngredientsRegist";
//	}
//	
//	/** メニューに戻る **/
//	// レシピ登録画面→メニュー
//	@PostMapping(value = "/regist", params = "menu_btn")
//	public String recipeRegistToMenu() {
//		return "recipe/today/todayRecipeMenu";
//	}
//	
//	// 食材登録画面→メニュー
//	@PostMapping(value = "/ingredientsRegist", params = "menu_btn")
//	public String ingredientsRegistToMenu() {
//		return "recipe/today/todayRecipeMenu";
//	}
//		
//	// 調味料登録画面→メニュー
//	@PostMapping(value = "/seasoningRegist", params = "menu_btn")
//	public String seasoningRegistToMenu() {
//		return "recipe/today/todayRecipeMenu";
//	}
//
//	/** 登録処理 **/
//	// レシピ登録画面で登録
//	@PostMapping(value = "/regist", params = "recipeRegist_btn")
//	public String recipeRegistExec(@ModelAttribute("RecipeDataForm")RecipeDataForm RecipeDataForm) {
//		// 登録処理実行
//		todayRecipeRegistService.insertRecipeExec(RecipeDataForm, "1");
//		if(commonMessageDTO.isResult()) {
//			return "redirect:/today-recipe-regist?success";
//		}
//		return "recipe/today/register/todayRecipeRegist";
//	}
//	
//	// 食材登録画面で登録
//	@PostMapping(value = "/ingredientsRegist", params = "ingredientsRegist_btn")
//	public String ingredientsRegistExec(@ModelAttribute("ingredientsListForm")IngredientsMasterForm ingredientsMasterForm) {
//		
//		todayRecipeRegistService.insertIngredientsExec(ingredientsMasterForm, "2"); 
//		if(commonMessageDTO.isResult()){
//			return "redirect:/today-recipe-ingredients-regist?success";
//		}
//		return "recipe/today/register/todayRecipeIngredientsRegist";
//	}
//	
//	// 調味料登録画面で登録
//	@PostMapping(value = "/seasoningRegist", params = "seasoningRegist_btn")
//	public String seasoningRegistExec(@ModelAttribute("seasoningListForm")SeasoningMasterForm seasoningMasterForm) {
//		
//		todayRecipeRegistService.insertSeasoningExec(seasoningMasterForm, "3");
//		if (commonMessageDTO.isResult()) {
//			return "redirect:/today-recipe--seasoning-regist?success";
//		}
//		return "recipe/today/register/todayRecipeSeasoningRegist";
//	}
//	
//	/** リダイレクト後の遷移 **/
//	// レシピ登録画面を初期化→メニュー
//	@PostMapping(value = "/today-recipe-regist", params = "success")
//	public String recipeRegistSuccess(SessionStatus sessionStatus) {
//		sessionStatus.setComplete();
//		return "recipe/today/todayRecipeMenu";
//	}
//	
//	// 食材登録画面を初期化
//	@PostMapping(value = "/today-recipe-ingredients-regist", params = "success")
//	public String ingredientsRegistSuccess(SessionStatus sessionStatus) {
//		sessionStatus.setComplete();
//		return "recipe/today/register/todayRecipeIngredientsRegist";
//	}
//	
//	// 調味料登録画面を初期化
//	@PostMapping(value = "/today-recipe-seasoning-regist", params = "success")
//	public String seasoningRegistSuccess(SessionStatus sessionStatus) {
//		sessionStatus.setComplete();
//		return "recipe/today/register/todayRecipeSeasoningRegist";
//	}

}
