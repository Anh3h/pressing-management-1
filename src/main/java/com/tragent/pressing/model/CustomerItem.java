package com.tragent.pressing.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

enum Status {
	PENDING,
	WASHING,
	READY
}

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name="customer_item")
@AssociationOverrides({
@AssociationOverride(name ="id.item", joinColumns = @JoinColumn(name="item_id")),
@AssociationOverride(name ="id.customer", joinColumns = @JoinColumn(name="customer_id"))
        })
public class CustomerItem implements Serializable {

	@EmbeddedId
	private CustomerItemId id = new CustomerItemId() ;
	
	@Column(nullable=false)
	private int quantity;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Status status;
	
	@Column(nullable=false, unique=true)
	private String label;
	
	@Column(nullable=false)
	private Date depositeDate = new Date();
	
	@Column(nullable=false)
	private Date dueDate;
	
	@OneToMany(mappedBy="customerItem", cascade=CascadeType.ALL)
	private List<Payment> payments;

	public CustomerItem() {
		super();
	}

	public Customer getCustomer() {
		return this.id.getCustomer();
	}

	public void setCustomer(Customer customer) {
		this.id.setCustomer(customer);
	}

	public Item getItem() {
		return this.id.getItem();
	}

	public void setItem(Item item) {
		this.id.setItem(item);
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDepositeDate() {
		return this.depositeDate;
	}

	public void setDepositeDate(Date depositeDate) {
		this.depositeDate = depositeDate;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
}
