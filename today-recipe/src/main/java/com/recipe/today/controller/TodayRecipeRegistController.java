package com.recipe.today.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.recipe.today.domain.model.IngredientsListForm;
import com.recipe.today.domain.model.RecipeListForm;
import com.recipe.today.domain.model.SeasoningListForm;
import com.recipe.today.domain.service.TodayRecipeRegistService;

@Controller
@SessionAttributes({"recipeListForm", "ingredientsListForm", "seasoningListForm"})
public class TodayRecipeRegistController {

	@Autowired
	private TodayRecipeRegistService todayRecipeRegistService;

	@ModelAttribute
	public RecipeListForm recipeListForm() {
		return new RecipeListForm();
	}

	@ModelAttribute
	public IngredientsListForm ingredientsListForm() {
		return new IngredientsListForm();
	}
	
	@ModelAttribute
	public SeasoningListForm seaosoningListForm() {
		return new SeasoningListForm();
	}

	// メニュー
	@RequestMapping("/")
	public String menu() {
		return "recipe/today/todayRecipeMenu";
	}

	/** 登録画面に遷移 **/
	// レシピ登録
	// メニュー→レシピ登録画面
	@RequestMapping(value = "/menu", params = "regist_start_btn")
	public String menuToRecipeRegist() {
		return "recipe/today/register/todayRecipeRegist";
	}

	// 食材登録
	// レシピ登録→食材登録
	@RequestMapping(value = "/regist", params = "ingredientsChange_btn")
	public String recepiRegistToIngredientsRegist() {
		
		return "recipe/today/register/todayRecipeIngredientsRegist";
	}
	
	// 調味料登録
	// 食材登録→調味料登録
	@RequestMapping(value = "/ingredientsRegist", params = "seasoningChange_btn")
	public String recepiRegistToSeasoningRegist() {
		
		return "recipe/today/register/todayRecipeSeasoningRegist";
	}
	// 調味料登録
	// 調味料登録→食材登録
	@RequestMapping(value = "/seasoningRegist", params = "ingredientsChange_btn")
	public String seasoningRegistToRecepiRegist() {
		
		return "recipe/today/register/todayRecipeIngredientsRegist";
	}
	
	/** メニューに戻る **/
	// レシピ登録画面→メニュー
	@RequestMapping(value = "/regist", params = "menu_btn")
	public String recipeRegistToMenu() {
		return "recipe/today/todayRecipeMenu";
	}
	
	// 食材登録画面→メニュー
	@RequestMapping(value = "/ingredientsRegist", params = "menu_btn")
	public String ingredientsRegistToMenu() {
		return "recipe/today/todayRecipeMenu";
	}
		
	// 調味料登録画面→メニュー
	@RequestMapping(value = "/seasoningRegist", params = "menu_btn")
	public String seasoningRegistToMenu() {
		return "recipe/today/todayRecipeMenu";
	}

	/** 登録処理 **/
	// レシピ登録画面で登録
	@RequestMapping(value = "/regist", params = "recipeRegist_btn")
	public String recipeRegistExec(@ModelAttribute("recipeListForm")RecipeListForm recipeListForm) {
		
		if (todayRecipeRegistService.insertRecipeExec(recipeListForm)) {
			return "redirect:/today-recipe-regist?success";
		}
		return "recipe/today/register/todayRecipeRegist";
	}
	
	// 食材登録画面で登録
	@RequestMapping(value = "/ingredientsRegist", params = "ingredientsRegist_btn")
	public String ingredientsRegistExec(@ModelAttribute("ingredientsListForm")IngredientsListForm ingredientsListForm) {
		
		if (todayRecipeRegistService.insertIngredientsExec(ingredientsListForm)) {
			return "redirect:/today-recipe-ingredients-regist?success";
		}
		return "recipe/today/register/todayRecipeIngredientsRegist";
	}
	
	// 調味料登録画面で登録
	@RequestMapping(value = "/seasoningRegist", params = "seasoningRegist_btn")
	public String seasoningRegistExec(@ModelAttribute("seasoningListForm")SeasoningListForm seasoningListForm) {
		
		if (todayRecipeRegistService.insertSeasoningExec(seasoningListForm)) {
			return "redirect:/today-recipe--seasoning-regist?success";
		}
		return "recipe/today/register/todayRecipeSeasoningRegist";
	}
	
	/** リダイレクト後の遷移 **/
	// レシピ登録画面を初期化→メニュー
	@RequestMapping(value = "/today-recipe-regist", params = "success")
	public String recipeRegistSuccess(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "recipe/today/todayRecipeMenu";
	}
	
	// 食材登録画面を初期化
	@RequestMapping(value = "/today-recipe-ingredients-regist", params = "success")
	public String ingredientsRegistSuccess(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "recipe/today/register/todayRecipeIngredientsRegist";
	}
	
	// 調味料登録画面を初期化
	@RequestMapping(value = "/today-recipe-seasoning-regist", params = "success")
	public String seasoningRegistSuccess(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "recipe/today/register/todayRecipeSeasoningRegist";
	}
	
	/** 選択画面 **/
	// 
	@RequestMapping(value = "/today-recipe-seasoning-regist", params = "success")
	public String menuToRecipeSpecific() {
		return "recipe/today/choise/todayRecipeSpecific";
	}
}
