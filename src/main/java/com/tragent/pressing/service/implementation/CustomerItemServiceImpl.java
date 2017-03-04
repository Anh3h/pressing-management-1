package com.tragent.pressing.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.tragent.pressing.model.CustomerItem;
import com.tragent.pressing.repository.CustomerItemRepository;
import com.tragent.pressing.service.CustomerItemService;

@Service
@Secured({"ROLE_MANAGEMENT", "ROLE_SALES_AGENT"})
public class CustomerItemServiceImpl implements CustomerItemService {
	
	@Autowired
	private CustomerItemRepository customerItemrepository;

	@Override
	public Collection<CustomerItem> findAll() {
		
		Collection<CustomerItem> customerItems = customerItemrepository.findAll();
		return customerItems;
	}

	@Override
	public Collection<CustomerItem> findByCustomerId(Long id) {
		
		Collection<CustomerItem> customerItem = customerItemrepository.findByCustomer(id);
		return customerItem;
	}

	@Override
	public Collection<CustomerItem> findByItemId(Long id) {
		
		Collection<CustomerItem> customerItem = customerItemrepository.findByItem(id);
		return customerItem;
	}

	@Override
	public CustomerItem create(CustomerItem customerItem) {
		
		CustomerItem savedCustomerItem = customerItemrepository.save(customerItem);
		return savedCustomerItem;
	}

	@Override
	public CustomerItem update(CustomerItem customerItem) {
		
		CustomerItem updatedCustomerItem = customerItemrepository.save(customerItem);
		return updatedCustomerItem;
	}

}
