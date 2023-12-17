package com.recipe.today.domain.entity;

public class SeasoningListDTO implements ListDTO{
	/** 調味料ID **/
	private int seasoningId;
	/** 調味料名 **/
	private String seasoningName;
	//TODO/** 調味料タイプ 1:砂糖, 2:塩, 3:酢, 4:醤油, 5:にんにく, 6:しょうが, 7:マヨネーズ, 8:ケチャップ等 **/
	private int seosoningType;
	/** 調味料優先度 **/
	private int seasoningPriority;
	/** 調味料画像 **/
	private String seasoningPicPath;
}
