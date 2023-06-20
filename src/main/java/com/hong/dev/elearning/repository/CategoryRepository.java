package com.hong.dev.elearning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hong.dev.elearning.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
	List<Category> findByNameContainingIgnoreCase(String name);

	//@TEST THIS REPO
	Optional<Category> findByActiveAndId(Boolean active, Long id);
}
