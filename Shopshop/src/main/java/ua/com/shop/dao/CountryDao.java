package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Country;

public interface CountryDao extends JpaRepository<Country, Integer>{

	Country findByName(String name);

	

}
