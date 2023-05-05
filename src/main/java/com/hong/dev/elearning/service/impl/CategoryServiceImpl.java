package com.hong.dev.elearning.service.impl;

import org.springframework.stereotype.Service;

import com.hong.dev.elearning.entity.Category;
import com.hong.dev.elearning.repository.CategoryRepository;
import com.hong.dev.elearning.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
	private final CategoryRepository categoryRepository;
	
	@Override
	public Category create(Category category) {
		return categoryRepository.save(category);
	}

}
