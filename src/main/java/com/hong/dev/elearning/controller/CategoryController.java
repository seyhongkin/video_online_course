package com.hong.dev.elearning.controller;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hong.dev.elearning.dto.CategoryDTO;
import com.hong.dev.elearning.dto.PageDTO;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long categoryId){
		Category category = categoryService.getById(categoryId);
		return ResponseEntity.ok(categoryMapper.toCategoryDTO(category));
	}
	
	//@TODO
	@GetMapping
	public ResponseEntity<?> getCategories(@RequestParam Map<String, String> params){
		Page<Category> categories = categoryService.getCategories(params);
		PageDTO pageDTO = new PageDTO(categories);
		
		return ResponseEntity.ok(pageDTO);
	}
	
	/*
	@GetMapping
	public ResponseEntity<?> getByName(@RequestParam("search") String name){
		List<Category> categories = categoryService.getByName(name);
		return ResponseEntity.ok(categories);
	}
	*/
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long categoryId, @RequestBody CategoryDTO categoryDTO){
		Category category = categoryMapper.toCategory(categoryDTO);
		category = categoryService.update(categoryId, category);
		return ResponseEntity.ok(categoryMapper.toCategoryDTO(category));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> remove(@PathVariable("id") Long categoryId){
		categoryService.remove(categoryId);
		return ResponseEntity.ok("category_id=%d deleted successfully".formatted(categoryId));
	}
}
