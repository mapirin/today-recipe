package com.recipe.today.domain.entity;

public class IngredientsMasterDTO implements ListDTO {

	/** 食材ID **/
	private int ingredientsId;
	/** 食材名 **/
	private String ingredientsName;
	/** 食材画像 **/
	private String ingredientsPicPath;
	/** 削除フラグ **/
	private String delFlg;
	
	/** **/
	public int getIngredientsId() {
		return ingredientsId;
	}
	public void setIngredientsId(int ingredientsId) {
		this.ingredientsId = ingredientsId;
	}
	public String getIngredientsName() {
		return ingredientsName;
	}
	public void setIngredientsName(String ingredientsName) {
		this.ingredientsName = ingredientsName;
	}
	public String getIngredientsPicPath() {
		return ingredientsPicPath;
	}
	public void setIngredientsPicPath(String ingredientsPicPath) {
		this.ingredientsPicPath = ingredientsPicPath;
	}
	public String getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
}
