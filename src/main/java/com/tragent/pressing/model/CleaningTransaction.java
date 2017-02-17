package com.tragent.pressing.model;

import java.util.Collection;

public class CleaningTransaction {
	
	private CustomerItem customerItem;
	
	private Collection<Payment> payments;

	public CleaningTransaction(CustomerItem customerItem, Collection<Payment> payments) {
		super();
		this.customerItem = customerItem;
		this.payments = payments;
	}

	public CustomerItem getCustomerItem() {
		return this.customerItem;
	}

	public void setCustomerItem(CustomerItem customerItem) {
		this.customerItem = customerItem;
	}

	public Collection<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Collection<Payment> payments) {
		this.payments = payments;
	}

}
