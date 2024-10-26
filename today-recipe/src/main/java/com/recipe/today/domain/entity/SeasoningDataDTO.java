package com.recipe.today.domain.entity;

public class SeasoningDataDTO implements ListDTO{
	
	/** 調味料キー **/
	private String seasoningKey;
	/** 調味料ID **/
	private int seasoningId;
	/** 調味料タイプID **/
	private int seasoningTypeId;
	/** 調味料並び順 **/
	private String seasoningOrder;
	
	/** **/
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
	public int getSeasoningTypeId() {
		return seasoningTypeId;
	}
	public void setSeasoningTypeId(int seasoningTypeId) {
		this.seasoningTypeId = seasoningTypeId;
	}
	public String getSeasoningOrder() {
		return seasoningOrder;
	}
	public void setSeasoningOrder(String seasoningOrder) {
		this.seasoningOrder = seasoningOrder;
	}
	
	
}
