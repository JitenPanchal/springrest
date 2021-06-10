package com.springrest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springrest.entities.membership.User;

public interface IUserRepository extends CrudRepository<User, Long> {
	
}