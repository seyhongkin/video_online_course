package com.hong.dev.elearning.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hong.dev.elearning.entity.Category;
import com.hong.dev.elearning.exceptions.ResourceNotFoundException;
import com.hong.dev.elearning.repository.CategoryRepository;
import com.hong.dev.elearning.service.CategoryService;
import com.hong.dev.elearning.service.util.PageUtil;
import com.hong.dev.elearning.spec.CategoryFilter;
import com.hong.dev.elearning.spec.CategorySpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	@Override
	public Category create(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getById(Long categoryId) {
		return categoryRepository.findByActiveAndId(true, categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", categoryId));
	}

	@Override
	public List<Category> getByName(String name) {
		return categoryRepository.findByNameContainingIgnoreCaseAndActive(name, true);
	}

	@Override
	public Category update(Long categoryId, Category categoryUpdate) {
		Category category = getById(categoryId);
		category.setName(categoryUpdate.getName());
		return categoryRepository.save(category);
	}

	@Override
	public void remove(Long categoryId) {
		Category category = getById(categoryId);
		categoryRepository.delete(category);
	}

	@Override
	public Page<Category> getCategories(Map<String, String> param) {
		CategoryFilter categoryFilter = new CategoryFilter();

		if (param.containsKey("name")) {
			String name = param.get("name");
			categoryFilter.setName(name);
		}
		if (param.containsKey("id")) {
			String id = param.get("id");
			categoryFilter.setId(Long.parseLong(id));
		}

		int pageNum = PageUtil.DEFAULT_PAGE_NUMBER;
		int pageSize = PageUtil.DEFAULT_PAGE_LIMIT;

		if (param.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNum = Integer.parseInt(param.get(PageUtil.PAGE_NUMBER));
		}
		if (param.containsKey(PageUtil.PAGE_LIMIT)) {
			pageSize = Integer.parseInt(param.get(PageUtil.PAGE_LIMIT));
		}

		CategorySpec categorySpec = new CategorySpec(categoryFilter);
		Pageable pageable = PageUtil.getPageable(pageNum, pageSize);
		
		Page<Category> page = categoryRepository.findAll(categorySpec, pageable);
		return page;
	}

	/*
	 * //@TODO create pagination
	 * 
	 * @Override public List<Category> getCategories() { return
	 * categoryRepository.findAllByActive(true); }
	 */
}
