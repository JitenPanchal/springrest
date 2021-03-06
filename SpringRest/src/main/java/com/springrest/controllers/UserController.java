package com.springrest.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.dtos.UserDto;
import com.springrest.entities.membership.User;
import com.springrest.exceptions.EntityNotFoundException;
import com.springrest.service.contracts.IMapper;
import com.springrest.service.contracts.IMembershipService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseApiController {

	private static final IMapper<UserDto, User> userDtoToEntityMapper = (UserDto dto) -> {

		var entity = new User();

		if (dto.getId()!=null)
			entity.setId(dto.getId());
		
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());

		return entity;
	};

	private static final IMapper<User, UserDto> userEntityToDtoMapper = (User entity) -> {

		var dto = new UserDto();

		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());

		return dto;
	};

	private final IMembershipService membershipService;

	@Autowired
	public UserController(IMembershipService membershipService) {
		super();
		this.membershipService = membershipService;
	}

	@GetMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDto> findUserById(@PathVariable("id") long id) {
		Optional<User> user = this.membershipService.findUserById(id);

		if (user.isPresent())
			return new ResponseEntity<UserDto>(userEntityToDtoMapper.map(user.get()), HttpStatus.OK);
		else
			throw new EntityNotFoundException(String.format("User entity with Id %d not found", id));
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

		var user = userDtoToEntityMapper.map(userDto);

		this.membershipService.save(user);

		return new ResponseEntity<UserDto>(userEntityToDtoMapper.map(user), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @Valid @RequestBody UserDto userDto) {

		var user = userDtoToEntityMapper.map(userDto);

		this.membershipService.save(user);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteUserById(@PathVariable("id") long id) {

		try {
			this.membershipService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (EmptyResultDataAccessException ex) {
			throw new EntityNotFoundException(String.format("User entity with Id %d not found", id));
		}

	}

}