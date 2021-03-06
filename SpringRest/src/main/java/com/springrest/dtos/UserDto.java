package com.springrest.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.springrest.validators.EntityId;

public class UserDto {

	@EntityId(message = "id must be between 1 and " + Long.MAX_VALUE + ".")
	private Long id;

	@Size(max = 250, message = "name field can be a maximum length of 250.")
	@NotBlank(message = "name field can not be empty.")
	private String name;

	@Size(max = 250, message = "email field can be a maximum length of 250.")
	@NotBlank(message = "email field can not be empty.")
	@Email(message = "invalid email")
	private String email;

	public UserDto() {
		super();
	}

	public UserDto(long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}