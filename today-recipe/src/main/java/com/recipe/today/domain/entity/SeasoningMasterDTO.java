package com.recipe.today.domain.entity;

public class SeasoningMasterDTO implements ListDTO{
	/** 調味料ID **/
	private int seasoningId;
	/** 調味料名 **/
	private String seasoningName;
	/** 調味料画像 **/
	private String seasoningPicPath;
	/** 削除フラグ **/
	private String delFlg;
	
	/** **/
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
	public String getSeasoningPicPath() {
		return seasoningPicPath;
	}
	public void setSeasoningPicPath(String seasoningPicPath) {
		this.seasoningPicPath = seasoningPicPath;
	}
	public String getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	
}
