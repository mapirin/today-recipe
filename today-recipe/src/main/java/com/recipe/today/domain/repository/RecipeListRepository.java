package com.recipe.today.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import com.recipe.today.domain.entity.ListDTO;

@Mapper
public interface RecipeListRepository {

	public void i(ListDTO listDTO);
	
	public ListDTO s();
}
