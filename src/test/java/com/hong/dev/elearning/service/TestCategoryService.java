package com.hong.dev.elearning.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hong.dev.elearning.entity.Category;
import com.hong.dev.elearning.exceptions.ResourceNotFoundException;
import com.hong.dev.elearning.repository.CategoryRepository;
import com.hong.dev.elearning.service.impl.CategoryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestCategoryService {
	@Mock
	private CategoryRepository categoryRepository;

	private CategoryService categoryService;

	@BeforeEach
	private void setUpService() {
		categoryService = new CategoryServiceImpl(categoryRepository);
	}

	@Test
	public void testCreate() {
		// given
		Category category = new Category();
		category.setName("Java Advance");
		category.setActive(true);

		// when
		categoryService.create(category);

		// then
		verify(categoryRepository, times(1)).save(category);
	}

	//@Test
	public void testGetByIdSuccess() {
		// given
		Category category = new Category();
		category.setName("Java Advance");
		category.setActive(true);
		category.setId(1L);

		// when
		when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
		Category cateReturn = categoryService.getById(1L);

		// then
		assertEquals(1L, cateReturn.getId());
		assertEquals(true, cateReturn.getActive());
		assertEquals("Java Advance", cateReturn.getName());
	}
	
	//@Test
	public void testGetByIdThrow() {
		//given
		
		//when
		when(categoryRepository.findById(2L)).thenReturn(Optional.empty());
		
		//then
		assertThatThrownBy(() -> categoryService.getById(2L))
			.isInstanceOf(ResourceNotFoundException.class)
			.hasMessageEndingWith("not found.");
	}
}
