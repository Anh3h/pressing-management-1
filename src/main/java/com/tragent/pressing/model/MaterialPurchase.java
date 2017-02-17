package com.tragent.pressing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MaterialPurchase {

	@Id
	@GeneratedValue
	private Long id;
	
	private Date purchasedDate = new Date();
	
	@Column(nullable=false)
	private Date expectedDepreciationDate = new Date();
	
	@Column(nullable=false)
	private Date actualDepreciationDate = new Date();
	
	@ManyToOne(optional=false)
	@JoinColumn(name="cleaning_material_id", referencedColumnName = "id")
	private CleaningMaterial cleaningMaterial;
	
}
