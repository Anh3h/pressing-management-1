package com.tragent.pressing.service.implementation;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.tragent.pressing.model.Payment;
import com.tragent.pressing.repository.PaymentRepository;
import com.tragent.pressing.service.PaymentService;

@Service
@Secured({"ROLE_MANAGEMENT", "ROLE_SALES_AGENT"})
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Collection<Payment> findAll() {
		
		Collection<Payment> payments = paymentRepository.findAll();
		return payments;
	}

	@Override
	public Collection<Payment> findByPaymentByCustomerItem(Long cutomerItemId) {
		
		Collection<Payment> payments = paymentRepository.findByCustomerItem(cutomerItemId);
		return payments;
	}

	@Override
	public Collection<Payment> findByPaymentByTime(Date time) {
		
		Collection<Payment> payments = paymentRepository.findByTime(time);
		return payments;
	}

	@Override
	public Payment create(Payment payment) {
		
		Payment savedPayment = paymentRepository.save(payment);
 		return savedPayment;
	}

	@Override
	public Payment update(Payment payment) {
		
		Payment updatedPayment = paymentRepository.save(payment);
		return updatedPayment;
	}

}
