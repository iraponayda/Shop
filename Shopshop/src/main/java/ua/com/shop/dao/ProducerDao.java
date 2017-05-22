package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.specification.ProducerSpecification;


public interface ProducerDao extends JpaRepository<Producer, Integer>,  JpaSpecificationExecutor<Producer> {

	
	@Query("SELECT p FROM Producer p LEFT JOIN FETCH p.country")
	List<Producer> findAll();
	
	@Query("SELECT p FROM Producer p LEFT JOIN FETCH p.country WHERE p.id = ?1")
	Producer findOne(int id);
	
	@Query("SELECT p FROM Producer p WHERE p.name=?1 and p.country.id=?2")
	Producer findUnique(String name, int countryId);
	
	@Query(value="SELECT p FROM Producer p LEFT JOIN FETCH p.country",
			countQuery="SELECT count(p.id) FROM Producer p")
	Page<Producer> findAll(Pageable pageable);

	
	
	
	
}
