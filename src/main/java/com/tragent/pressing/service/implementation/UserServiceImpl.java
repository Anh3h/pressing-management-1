package com.tragent.pressing.service.implementation;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.tragent.pressing.model.CustomUser;
import com.tragent.pressing.repository.UserRepository;
import com.tragent.pressing.service.UserService;

@Service
@Secured("ROLE_MANAGEMENT")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Collection<CustomUser> findAll() {
		
		List<CustomUser> users = userRepository.findAll();
		return users;
	}

	@Override
	public CustomUser findById(Long id) {
		
		CustomUser user = userRepository.findOne(id);
		return user;
	}

	@Override
	public CustomUser findByUserName(String username) {
		
		CustomUser user = userRepository.findByUsername(username);
		return user;
	}

	@Override
	public CustomUser create(CustomUser user) {
		
		if (userRepository.exists(user.getId())) {
			return null;
		}
		CustomUser savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public CustomUser update(CustomUser user) {
		
		if (userRepository.exists(user.getId())) {
			return null;
		}
		CustomUser savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public void delete(Long id) {
		
		CustomUser user = findById(id);
		if (user == null) {
			return;
		}
		
		userRepository.delete(user);
	}

}
