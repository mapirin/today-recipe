package com.recipe.today.domain.repository;

import com.recipe.today.domain.entity.ListDTO;
import com.recipe.today.domain.entity.SeasoningListDTO;

public interface SeasoningListRepository {
	
	public SeasoningListDTO i(ListDTO listDTO);
}
