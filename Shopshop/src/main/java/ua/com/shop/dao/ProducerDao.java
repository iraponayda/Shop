package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Producer;


public interface ProducerDao extends JpaRepository<Producer, Integer> {

	
	@Query("SELECT p FROM Producer p LEFT JOIN FETCH p.country")
	List<Producer> findAll();
	
	@Query("SELECT p FROM Producer p LEFT JOIN FETCH p.country WHERE p.id = ?1")
	Producer findOne(int id);
}
