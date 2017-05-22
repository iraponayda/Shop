package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dto.ToyForm;
import ua.com.shop.dto.filter.ToyFilter;
import ua.com.shop.entity.Age;
import ua.com.shop.entity.Gender;
import ua.com.shop.entity.Material;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.entity.Toy;

public interface ToyService {
	void save(ToyForm entity);
	List<Toy> findAll();
	Toy findOne(int id);
	void delate (int id);
		List<Toy> findByGenderId(int id);
	List<Toy> findByAgeId(int id);
	Toy findUnique(String name, Age age, Gender gender, Material material, String price, Subcategory subcategory, Producer producer);
	ToyForm findForm(int id);
	
	Page<Toy> findAll(Pageable pageable, ToyFilter filter);
}
