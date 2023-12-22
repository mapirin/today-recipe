package com.recipe.today.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeasoningListForm implements Serializable, ListForm{
	private final static long serialVersionUID=1L;
	
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
	public int getSeosoningType() {
		return seosoningType;
	}
	public void setSeosoningType(int seosoningType) {
		this.seosoningType = seosoningType;
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

	public List<Integer> getDepositYearList() {
		List<Integer> depositYearList = new ArrayList<>();
		int year = LocalDate.now().getYear();

		for (int i = year - 3; i <= year; i++) {
			depositYearList.add(i);
		}

		return depositYearList;
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
