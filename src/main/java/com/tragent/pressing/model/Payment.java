package com.tragent.pressing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(nullable=false)
	private double amount;
	
	@Column(nullable=false)
	private Date time = new Date();
	
	@ManyToOne(optional=false)
	@JoinColumns({
        @JoinColumn(name="customer_id", referencedColumnName="customer_id"),
        @JoinColumn(name="item_id", referencedColumnName="item_id")
    })
	private CustomerItem customerItem;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="payment_method_id", referencedColumnName = "id")
	private PaymentMethod paymentMethod;

	public Long getId() {
		return this.Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CustomerItem getCustomerItem() {
		return this.customerItem;
	}

	public void setCustomerItem(CustomerItem customerItem) {
		this.customerItem = customerItem;
	}

	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
