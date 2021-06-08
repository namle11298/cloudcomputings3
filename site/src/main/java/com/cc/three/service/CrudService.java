package com.cc.three.service;

public interface CrudService<T> {

	T create(T obj);
	T read(String id);
	T update(T obj);
	void delete(String id);

}
