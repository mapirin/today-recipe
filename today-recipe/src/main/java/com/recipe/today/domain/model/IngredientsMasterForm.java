package com.recipe.today.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IngredientsMasterForm implements Serializable{
	private final static long serialVersionUID=1L;
	
	private int ingredientsId;
	//TODO/** 具材タイプ 1:肉, 2:魚, :, 2:調味料, 2:調味料, 2:調味料, 2:調味料 **/
	private int ingredientsTypeId;
	/** 食材名 **/
	private String ingredientsName;
	/** 食材画像 **/
	private String ingredientsPicPath;
	/** 食材並び順 **/
	private String ingredientsOrder;
	
	public int getIngredientsId() {
		return ingredientsId;
	}
	public void setIngredientsId(int ingredientsId) {
		this.ingredientsId = ingredientsId;
	}
	public int getIngredientsTypeId() {
		return ingredientsTypeId;
	}
	public void setIngredientsTypeId(int ingredientsTypeId) {
		this.ingredientsTypeId = ingredientsTypeId;
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
	public String getIngredientsOrder() {
		return ingredientsOrder;
	}
	public void setIngredientsOrder(String ingredientsOrder) {
		this.ingredientsOrder = ingredientsOrder;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}