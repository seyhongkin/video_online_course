package com.hong.dev.elearning.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hong.dev.elearning.entity.Category;

@DataJpaTest
public class TestCategoryRepository {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void testFindByNameContainingIgnoreCase() {
		//given
		Category category = new Category();
		category.setName("Java");
		categoryRepository.save(category);
		
		//when 
		List<Category> categories = categoryRepository.findByNameContainingIgnoreCase("j");
		
		//then
		assertEquals(1, categories.size());
		assertEquals(1,categories.get(0).getId());
		assertEquals("Java", categories.get(0).getName());
	}
	
}
