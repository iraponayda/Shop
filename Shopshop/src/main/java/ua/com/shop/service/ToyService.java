package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Toy;

public interface ToyService {
	void save(Toy toy);
	List<Toy> findAll();
	Toy findOne(int id);
	void delate (int id);
		List<Toy> findByGenderId(int id);
	List<Toy> findByAgeId(int id);
}
