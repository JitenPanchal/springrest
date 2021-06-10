package com.springrest.service.contracts;

@FunctionalInterface
public interface IMapper<TypeFrom, TypeTo> {
	TypeTo map(TypeFrom entity);
}