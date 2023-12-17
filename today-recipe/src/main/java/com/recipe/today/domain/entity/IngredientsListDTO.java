package com.recipe.today.domain.entity;

public class IngredientsListDTO implements ListDTO {
	/** 食材ID **/
	private int ingredientsId;
	/** 食材名 **/
	private String ingredientsName;
	//TODO/** 具材タイプ 1:肉, 2:魚, :, 2:調味料, 2:調味料, 2:調味料, 2:調味料 **/
	private int ingredientsType;
	/** 食材優先度 **/
	private int ingredientsPriority;
	/** 食材画像 **/
	private String indredientsPicPath;

}
