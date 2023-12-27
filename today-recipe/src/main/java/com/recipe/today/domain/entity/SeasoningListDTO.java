package com.recipe.today.domain.entity;

public class SeasoningListDTO implements ListDTO{
	/** 調味料ID **/
	private int seasoningId;
	/** 調味料名 **/
	private String seasoningName;
	//TODO/** 調味料タイプ 1:砂糖, 2:塩, 3:酢, 4:醤油, 5:にんにく, 6:しょうが, 7:マヨネーズ, 8:ケチャップ等 **/
	private int seasoningType;
	/** 調味料優先度 **/
	private int seasoningPriority;
	/** 調味料画像 **/
	private String seasoningPicPath;
	
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
	public int getSeasoningType() {
		return seasoningType;
	}
	public void setSeasoningType(int seasoningType) {
		this.seasoningType = seasoningType;
	}
	public int getSeasoningPriority() {
		return seasoningPriority;
	}
	public void setSeasoningPriority(int seasoningPriority) {
		this.seasoningPriority = seasoningPriority;
	}
	public String getSeasoningPicPath() {
		return seasoningPicPath;
	}
	public void setSeasoningPicPath(String seasoningPicPath) {
		this.seasoningPicPath = seasoningPicPath;
	}
	
}
