package com.tragent.pressing.service.implementation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tragent.pressing.model.PaymentMethod;
import com.tragent.pressing.repository.PaymentMethodRepository;
import com.tragent.pressing.service.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{
	
	@Autowired
	private PaymentMethodRepository paymentMethodRepository;

	@Override
	public Collection<PaymentMethod> findAll() {
		
		Collection<PaymentMethod> paymentMethod = paymentMethodRepository.findAll();
		return paymentMethod;
		
	}

	@Override
	public PaymentMethod findById(Long id) {
		
		PaymentMethod paymentMethod = paymentMethodRepository.findOne(id);
		return paymentMethod;
		
	}

	@Override
	public PaymentMethod findByName(String name) {
		
		PaymentMethod paymentMethod = paymentMethodRepository.findByName(name);
		return paymentMethod;
	}

	@Override
	public PaymentMethod create(PaymentMethod paymentMethod) {
		
		if (paymentMethodRepository.exists(paymentMethod.getId())) {
			return null;
		}
		
		PaymentMethod savedPaymentMethod = paymentMethodRepository.save(paymentMethod);
		return savedPaymentMethod;
		
	}

	@Override
	public PaymentMethod update(PaymentMethod paymentMethod) {

		if (paymentMethodRepository.exists(paymentMethod.getId())) {
			return null;
		}
		
		PaymentMethod savedPaymentMethod = paymentMethodRepository.save(paymentMethod);
		return savedPaymentMethod;
		
	}

	@Override
	public void delete(Long id) {
		
		PaymentMethod paymentMethod = findById(id);
		if (paymentMethod == null) {
			return;
		}
		
		paymentMethodRepository.delete(id);
		
	}

}
