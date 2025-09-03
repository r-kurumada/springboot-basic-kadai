package com.example.springkadaitodo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "todos")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "priority")
	private priority priority;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private status status;
}
