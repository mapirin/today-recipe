package com.recipe.today.domain.repository;

import com.recipe.today.domain.entity.SeasoningMasterDTO;

public interface SeasoningRepository {
	
	public int duplicateCheck(String recipeName);
	
	public void i(SeasoningMasterDTO seasoningMasterDTO);
}
