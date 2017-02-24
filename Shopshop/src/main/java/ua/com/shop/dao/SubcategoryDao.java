package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Subcategory;



public interface SubcategoryDao extends JpaRepository<Subcategory, Integer> {

	
	@Query("SELECT s FROM Subcategory s LEFT JOIN FETCH s.category")
	List<Subcategory> findAll();
	
	@Query("SELECT s FROM Subcategory s LEFT JOIN FETCH s.category WHERE s.id = ?1")
	Subcategory findOne(int id);
}
