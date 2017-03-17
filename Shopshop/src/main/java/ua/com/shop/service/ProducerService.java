package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.ProducerFilter;
import ua.com.shop.entity.Country;
import ua.com.shop.entity.Producer;

public interface ProducerService {
	void save(Producer producer);
	List<Producer> findAll();
	Producer findOne(int id);
	void delete(int id);
	Producer findUnique(String name, Country country);
	Page<Producer> findAll(Pageable pageable, ProducerFilter filter);

}
