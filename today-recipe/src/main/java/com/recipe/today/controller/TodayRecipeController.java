package com.recipe.today.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.recipe.today.common.util.TodayRecipeUtil;
import com.recipe.today.domain.model.IngredientsListForm;
import com.recipe.today.domain.model.RecipeListForm;
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

	// 登録
	// メニュー→登録画面
	@RequestMapping(value = "/menu", params = "regist_start_btn")
	public String menuToRegist() {
		return "recipe/today/register/todayRecipeRegist";
	}

	// 登録画面→メニュー
	@RequestMapping(value = "/regist", params = "menu_btn")
	public String registToMenu() {
		return "recipe/today/todayRecipeMenu";
	}

	// TODO リダイレクト 登録画面で登録
	@RequestMapping(value = "regist_exec", params = "menu_btn")
	public String registExec(@ModelAttribute("recipeListForm")RecipeListForm recipeListForm) {
		// TODO 入力値受け取り＆値受け渡し処理
		if (todayRecipeService.insertExec(recipeListForm, TodayRecipeUtil.LIST_TYPE_RECIPE)) {
			return "recipe/today/todayRecipeMenu";
		}
		return "recipe/today/todayRecipeMenu";
	}
}
