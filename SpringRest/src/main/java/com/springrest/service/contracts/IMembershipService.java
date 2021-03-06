package com.springrest.service.contracts;

import java.util.Optional;

import com.springrest.entities.membership.User;

public interface IMembershipService {

	Optional<User> findUserById(Long id);

	User save(User entity);

	void deleteById(Long id);
}