package com.recipe.today.domain.repository;

import com.recipe.today.domain.entity.SeasoningListDTO;

public interface SeasoningListRepository {
	
	public int duplicateCheck(String recipeName);
	
	public void i(SeasoningListDTO seasoningListDTO);
}
