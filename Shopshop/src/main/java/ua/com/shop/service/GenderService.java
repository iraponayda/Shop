package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Gender;

public interface GenderService {

	void save(Gender gender);
	List<Gender> findAll();
	Gender findOne(int id);
	void delete(int id);
}
