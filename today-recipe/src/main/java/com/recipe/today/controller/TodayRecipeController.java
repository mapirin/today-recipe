package com.recipe.today.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.recipe.today.common.util.TodayRecipeUtil;
import com.recipe.today.domain.model.IngredientsListForm;
import com.recipe.today.domain.model.RecipeListForm;
import com.recipe.today.domain.model.SeasoningListForm;
import com.recipe.today.domain.service.TodayRecipeService;

@Controller
@SessionAttributes("recipeListForm")
public class TodayRecipeController {

	@Autowired
	private TodayRecipeService todayRecipeService;

	@ModelAttribute
	public RecipeListForm recipeListForm() {
		return new RecipeListForm();
	}

	@ModelAttribute
	public IngredientsListForm ingredientsListForm() {
		return new IngredientsListForm();
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
		
		return "recipe/today/todayRecipeIngredientsRegist";
	}
	
	// 調味料登録
	// 食材登録→調味料登録
	@RequestMapping(value = "/ingredientsRegist", params = "seasoningChange_btn")
	public String recepiRegistToSeasoningRegist() {
		
		return "recipe/today/todayRecipeSeasoningRegist";
	}
	// 調味料登録
	// 調味料登録→食材登録
	@RequestMapping(value = "/seasoningRegist", params = "ingredientsChange_btn")
	public String seasoningRegistToRecepiRegist() {
		
		return "recipe/today/todayRecipeSeasoningRegist";
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
	// TODO リダイレクト 登録画面で登録
	@RequestMapping(value = "/regist", params = "recipeRegist_btn")
	public String recipeRegistExec(@ModelAttribute("recipeListForm")RecipeListForm recipeListForm) {
		// TODO 入力値受け取り＆値受け渡し処理
		if (todayRecipeService.insertExec(recipeListForm, TodayRecipeUtil.LIST_TYPE_RECIPE)) {
			return "recipe/today/todayRecipeMenu";
		}
		return "recipe/today/todayRecipeMenu";
	}
	
	// TODO リダイレクト 食材登録画面で登録
	@RequestMapping(value = "/ingredientsRegist", params = "ingredientsRegist_btn")
	public String ingredientsRegistExec(@ModelAttribute("ingredientsListForm")IngredientsListForm ingredientsListForm) {
		// TODO 入力値受け取り＆値受け渡し処理
		
		if (todayRecipeService.insertExec(ingredientsListForm, TodayRecipeUtil.LIST_TYPE_INGREDIENTS)) {
			return "recipe/today/todayRecipeMenu";
		}
		return "recipe/today/todayRecipeMenu";
	}
	
	// TODO リダイレクト 調味料登録画面で登録
	@RequestMapping(value = "/seasoningRegist", params = "seasoningRegist_btn")
	public String seasoningRegistExec(@ModelAttribute("seasoningListForm")SeasoningListForm seasoningListForm) {
		// TODO 入力値受け取り＆値受け渡し処理
		
		if (todayRecipeService.insertExec(seasoningListForm, TodayRecipeUtil.LIST_TYPE_SEASONING)) {
			return "recipe/today/todayRecipeMenu";
		}
		return "recipe/today/todayRecipeMenu";
	}
}
