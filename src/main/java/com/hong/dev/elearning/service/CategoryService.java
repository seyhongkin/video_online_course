package com.hong.dev.elearning.service;

import java.util.List;

import com.hong.dev.elearning.entity.Category;

public interface CategoryService {
	Category create(Category category);
	Category getById(Long categoryId);
	List<Category> getByName(String name);
	Category update(Long categoryId, Category categoryUpdate);
	List<Category> getActive(Long categoryId);
}
