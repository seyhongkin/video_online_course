package com.hong.dev.elearning.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.hong.dev.elearning.entity.Category;

public interface CategoryService {
	Category create(Category category);
	Category getById(Long categoryId);
	List<Category> getByName(String name);
	Category update(Long categoryId, Category categoryUpdate);
	Page<Category> getCategories(Map<String, String> param);
	void remove(Long categoryId);
}
