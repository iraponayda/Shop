package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Age;

public interface AgeService {
	void save(Age age);
	List<Age> findAll();
	Age findOne(int id);
	void delete (int id);

}
