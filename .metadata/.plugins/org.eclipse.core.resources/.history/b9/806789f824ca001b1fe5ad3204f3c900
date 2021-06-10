package com.springrest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.springrest.entities.membership.User;
import com.springrest.repositories.IUserRepository;
import com.springrest.service.contracts.IMembershipService;

public class MembershipService implements IMembershipService {

	private final IUserRepository userRepository;

	@Autowired
	public MembershipService(IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		this.userRepository.deleteById(id);
		
	}

}