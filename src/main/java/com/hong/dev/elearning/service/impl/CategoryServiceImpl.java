package com.hong.dev.elearning.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hong.dev.elearning.entity.Category;
import com.hong.dev.elearning.exceptions.ResourceNotFoundException;
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

	@Override
	public Category getById(Long categoryId) {
		
		return categoryRepository
				.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", categoryId));
	}

	@Override
	public List<Category> getByName(String name) {
		return categoryRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public Category update(Long categoryId, Category categoryUpdate) {
		Category category = getById(categoryId);
		category.setName(categoryUpdate.getName());
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getActive(Long categoryId) {
		return categoryRepository.findByActiveAndId(true, categoryId);
	}

}
