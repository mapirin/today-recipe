package com.recipe.today.domain.entity;

public class RecipeDataDTO implements ListDTO {

	/** **/
	private int recipeId;
	private String recipeName;
	private String ingredientsKey;
	private int ingredientsId;
	private String ingredientsName;
	private String ingredientsOrder;
	private String seasoningKey;
	private int seasoningId;
	private String seasoningName;
	private String seasoningOrder;
	private String processKey;
	private int processId;
	private String process;
	private int cookingTime;
	private String moodKey;
	private int moodId;
	private String moodName;
	private int recipeTypeId;
	private String typeName;
	
	/**  **/
		public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
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
	public String getIngredientsName() {
		return ingredientsName;
	}
	public void setIngredientsName(String ingredientsName) {
		this.ingredientsName = ingredientsName;
	}
	public String getIngredientsOrder() {
		return ingredientsOrder;
	}
	public void setIngredientsOrder(String ingredientsOrder) {
		this.ingredientsOrder = ingredientsOrder;
	}
	public String getSeasoningKey() {
		return seasoningKey;
	}
	public void setSeasoningKey(String seasoningKey) {
		this.seasoningKey = seasoningKey;
	}
	public int getSeasoningId() {
		return seasoningId;
	}
	public void setSeasoningId(int seasoningId) {
		this.seasoningId = seasoningId;
	}
	public String getSeasoningName() {
		return seasoningName;
	}
	public void setSeasoningName(String seasoningName) {
		this.seasoningName = seasoningName;
	}
	public String getSeasoningOrder() {
		return seasoningOrder;
	}
	public void setSeasoningOrder(String seasoningOrder) {
		this.seasoningOrder = seasoningOrder;
	}
	public String getProcessKey() {
		return processKey;
	}
	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}
	public String getMoodKey() {
		return moodKey;
	}
	public void setMoodKey(String moodKey) {
		this.moodKey = moodKey;
	}
	public int getMoodId() {
		return moodId;
	}
	public void setMoodId(int moodId) {
		this.moodId = moodId;
	}
	public String getMoodName() {
		return moodName;
	}
	public void setMoodName(String moodName) {
		this.moodName = moodName;
	}
	public int getRecipeTypeId() {
		return recipeTypeId;
	}
	public void setRecipeTypeId(int recipeTypeId) {
		this.recipeTypeId = recipeTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	

}
