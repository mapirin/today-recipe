package com.recipe.today.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IngredientsListForm implements Serializable, ListForm{
	private final static long serialVersionUID=1L;
	
	private int ingredientsId;
	/** 食材名 **/
	private String ingredientsName;
	//TODO/** 具材タイプ 1:肉, 2:魚, :, 2:調味料, 2:調味料, 2:調味料, 2:調味料 **/
	private int ingredientsTypeId;
	/** 食材優先度 **/
	private int ingredientsPriority;
	/** 食材画像 **/
	private String indredientsPicPath;
	
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
	public int getIngredientsTypeId() {
		return ingredientsTypeId;
	}
	public void setIngredientsTypeId(int ingredientsTypeId) {
		this.ingredientsTypeId = ingredientsTypeId;
	}
	public int getIngredientsPriority() {
		return ingredientsPriority;
	}
	public void setIngredientsPriority(int ingredientsPriority) {
		this.ingredientsPriority = ingredientsPriority;
	}
	public String getIndredientsPicPath() {
		return indredientsPicPath;
	}
	public void setIndredientsPicPath(String indredientsPicPath) {
		this.indredientsPicPath = indredientsPicPath;
	}

	public List<String> getDepositMonthList() {
		List<String> depositMonthList = new ArrayList<>();
		String month="";

		for (int i = 1; i <= 12; i++) {
			month = String.format("%02d", i);
			depositMonthList.add(month);
		}

		return depositMonthList;
	}

	public List<String> getDepositDayList() {
		List<String> depositDayList = new ArrayList<>();
		String day = "";

		for (int i = 1; i <= 31; i++) {
			day = String.format("%02d", i);
			depositDayList.add(day);
		}

		return depositDayList;
	}
}
