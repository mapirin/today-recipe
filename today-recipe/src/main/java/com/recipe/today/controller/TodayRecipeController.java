package com.recipe.today.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodayRecipeController {

//	@Autowired
//	private TodayRecipeService todayRecipeService;
	
	// メニュー 
	@RequestMapping("/")
	public String menu() {
		return "recipe/today/todayRecipeMenu";
	}
	// メニュー→登録画面
	@RequestMapping(value = "/menu", params = "regist_btn")
	public String menuToRegist() {
		return "recipe/today/register/todayRecipeRegist";
	}
	// 登録画面→メニュー
	@RequestMapping(value = "/regist", params = "menu_btn")
	public String registToMenu() {
		return "recipe/today/todayRecipeMenu";
	}
	// 
}
