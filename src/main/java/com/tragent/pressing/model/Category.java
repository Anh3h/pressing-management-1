package com.tragent.pressing.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String name;
		
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=true)
	private String description;
	
	@OneToMany( mappedBy = "category", cascade = CascadeType.ALL )
	private List<Item> items;
	
	@OneToMany( mappedBy="category", cascade = CascadeType.ALL )
	private List<CleaningMaterial> cleaningMaterials;
	
	public Category() {
		super();
	}

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}	
	
}
