package com.hong.dev.elearning.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name = "course_name")
	private String name;
	
	//private Boolean active;

	@CreationTimestamp
	@Column(name = "create_at", updatable = false)
	private LocalDateTime createAt;
	
	@Nullable
	@UpdateTimestamp
	@Column(name = "update_at")
	private LocalDateTime updateAt;
}
