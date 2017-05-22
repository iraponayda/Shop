package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import ua.com.shop.dto.filter.SubcategoryFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Subcategory;

public interface SubcategoryService {
	void save(Subcategory subcategory);
	List<Subcategory> findAll();
	Subcategory findOne(int id);
	void delete(int id);
	Subcategory findUnique(String name, Category category);
	Page<Subcategory> findAll(Pageable pageable, SubcategoryFilter filter);
}
