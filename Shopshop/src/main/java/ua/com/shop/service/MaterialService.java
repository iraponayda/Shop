package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Material;

public interface MaterialService {

	
	void save(Material material);
	List<Material> findAll();
	Material findOne(int id);
	void delete(int id);
	
	Material findByMaterial(String material);
	Page<Material> findAll(Pageable pageable, SimpleFilter filter);
}
