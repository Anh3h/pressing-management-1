package com.tragent.pressing.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CustomerItemId implements Serializable {

	//@Id
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=ServerRequest.class)
	@ManyToOne(optional=false)
	//@JoinColumn(name="customer_id", referencedColumnName = "id")
	private Customer customer;
	
	//@Id
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=ServerRequest.class)
	@ManyToOne(optional=false)
	//@JoinColumn(name="item_id", referencedColumnName = "id")
	private Item item;

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
