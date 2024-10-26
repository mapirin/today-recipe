package com.recipe.today.domain.entity;

public class IngredientsDataDTO implements ListDTO {

	/** 食材キー **/
	private String ingredientsKey;
	/** 食材ID **/
	private int ingredientsId;
	/** 食材タイプID **/
	private int ingredientsTypeId;
	/** 食材並び順 **/
	private String ingredientsOrder;
	
	/** **/
	public String getIngredientsKey() {
		return ingredientsKey;
	}
	public void setIngredientsKey(String ingredientsKey) {
		this.ingredientsKey = ingredientsKey;
	}
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
	public String getIngredientsOrder() {
		return ingredientsOrder;
	}
	public void setIngredientsOrder(String ingredientsOrder) {
		this.ingredientsOrder = ingredientsOrder;
	}
	
	

}
