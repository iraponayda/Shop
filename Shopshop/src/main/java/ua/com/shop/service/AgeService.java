package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Age;

public interface AgeService {
	void save(Age age);
	List<Age> findAll();
	Age findOne(int id);
	void delete (int id);
	Age findByName(String age);
	Page<Age> findAll(Pageable pageable, SimpleFilter filter);

}
