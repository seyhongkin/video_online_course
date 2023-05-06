package com.hong.dev.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hong.dev.elearning.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	List<Category> findByNameContainingIgnoreCase(String name);
	List<Category> findByActiveAndId(Boolean active,Long id);
}
