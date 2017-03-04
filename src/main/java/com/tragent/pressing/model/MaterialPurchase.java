package com.tragent.pressing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="expense")
public class MaterialPurchase {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private Date purchasedDate = new Date();
	
	@Column(nullable=false)
	private Date expectedDepreciationDate = new Date();
	
	@Column(nullable=true)
	private Date actualDepreciationDate = new Date();
	
	@ManyToOne(optional=false)
	@JoinColumn(name="cleaning_material_id", referencedColumnName = "id")
	private CleaningMaterial cleaningMaterial;

	public MaterialPurchase() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPurchasedDate() {
		return this.purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public Date getExpectedDepreciationDate() {
		return this.expectedDepreciationDate;
	}

	public void setExpectedDepreciationDate(Date expectedDepreciationDate) {
		this.expectedDepreciationDate = expectedDepreciationDate;
	}

	public Date getActualDepreciationDate() {
		return this.actualDepreciationDate;
	}

	public void setActualDepreciationDate(Date actualDepreciationDate) {
		this.actualDepreciationDate = actualDepreciationDate;
	}

	public CleaningMaterial getCleaningMaterial() {
		return this.cleaningMaterial;
	}

	public void setCleaningMaterial(CleaningMaterial cleaningMaterial) {
		this.cleaningMaterial = cleaningMaterial;
	}
	
}
