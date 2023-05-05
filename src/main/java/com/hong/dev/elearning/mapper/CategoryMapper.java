package com.hong.dev.elearning.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.hong.dev.elearning.dto.CategoryDTO;
import com.hong.dev.elearning.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	CategoryDTO toCategoryDTO(Category category);

	Category toCategory(CategoryDTO categoryDTO);

}
