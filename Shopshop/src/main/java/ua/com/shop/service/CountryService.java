package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Country;

public interface CountryService {
	
	void save(Country country);
	List<Country> findAll();
	Country findOne(int id);
	void delete(int id);
	

}
