package com.hong.dev.elearning.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.hong.dev.elearning.entity.Category;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CategorySpec implements Specification<Category>{
	private final CategoryFilter categoryFilter;
	
	List<Predicate> predicates = new ArrayList<>();
	
	@Override
	public Predicate toPredicate(Root<Category> categoryRoot, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(categoryFilter.getId() != null) {
			Predicate predicateId = categoryRoot.get("id").in(categoryFilter.getId());
			predicates.add(predicateId);
		}
		if(categoryFilter.getName() != null) {
			Predicate predicateName = cb.like(cb.lower(categoryRoot.get("name")), "%" + categoryFilter.getName().toLowerCase() + "%");
			predicates.add(predicateName);
		}
		if(categoryFilter.getActive() != null) {
			Predicate predicateActive = cb.equal(categoryRoot.get("active"), categoryFilter.getActive());
			predicates.add(predicateActive);
		}
		return cb.and(predicates.toArray(Predicate[]::new));
	}

}
