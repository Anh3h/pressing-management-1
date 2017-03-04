package com.tragent.pressing.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.tragent.pressing.model.CleaningTransaction;
import com.tragent.pressing.model.CustomerItem;
import com.tragent.pressing.model.Payment;
import com.tragent.pressing.repository.CustomerItemRepository;
import com.tragent.pressing.service.CustomerTransactionService;

@Service
@Secured({"ROLE_MANAGEMENT", "ROLE_SALES_AGENT"})
public class CustomerTransactionServiceImpl implements CustomerTransactionService {
	
	@Autowired
	private CustomerItemRepository customerItemRepository;

	@Override
	public Collection<CleaningTransaction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CleaningTransaction> findByDueDate(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Collection<CleaningTransaction> findByDepositeDate(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CleaningTransaction create(CleaningTransaction cleaningTransaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CleaningTransaction update(CleaningTransaction cleaningTransaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CleaningTransaction findByCustomerId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CleaningTransaction findByItemId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Payment> getPayments(CustomerItem customerItem) {
		// TODO Auto-generated method stub
		return null;
	}

}
