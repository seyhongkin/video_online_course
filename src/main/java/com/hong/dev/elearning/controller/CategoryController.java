package com.hong.dev.elearning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hong.dev.elearning.dto.CategoryDTO;
import com.hong.dev.elearning.entity.Category;
import com.hong.dev.elearning.mapper.CategoryMapper;
import com.hong.dev.elearning.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {
	private final CategoryService categoryService;
	private final CategoryMapper categoryMapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CategoryDTO categoryDTO){
		Category category = categoryMapper.toCategory(categoryDTO);
		category = categoryService.create(category);
		return ResponseEntity.ok(categoryMapper.toCategoryDTO(category));
	}
}
