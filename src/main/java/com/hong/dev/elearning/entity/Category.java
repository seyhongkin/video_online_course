package com.hong.dev.elearning.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Entity(name = "categories")
public class Category {
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "category_name")
	private String name;
	
	private Boolean active;
	
	@CreationTimestamp
	@Column(name = "create_at", updatable = false)
	private LocalDateTime createAt;
	
	@Nullable
	@UpdateTimestamp
	@Column(name = "update_at")
	private LocalDateTime updateAt;

}
