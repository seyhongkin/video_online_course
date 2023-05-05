package com.hong.dev.elearning.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	@Column(name = "create_at")
	private LocalDateTime createAt;
	
	@Column(name = "update_at")
	private LocalDateTime updateAt;
}
