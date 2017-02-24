package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Producer;

public interface ProducerService {
	void save(Producer producer);
	List<Producer> findAll();
	Producer findOne(int id);
	void delete(int id);
}
