package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;



public interface SubcategoryDao extends JpaRepository<Subcategory, Integer>, JpaSpecificationExecutor<Subcategory> {

	
	@Query("SELECT s FROM Subcategory s LEFT JOIN FETCH s.category")
	List<Subcategory> findAll();
	
	@Query("SELECT s FROM Subcategory s LEFT JOIN FETCH s.category WHERE s.id = ?1")
	Subcategory findOne(int id);

	@Query("SELECT s FROM Subcategory s WHERE s.name=?1 and s.category.id=?2")
	Subcategory findUnique(String name, int id);
	
	@Query(value="SELECT s FROM Subcategory s LEFT JOIN FETCH s.category",
			countQuery="SELECT count(s.id) FROM Subcategory s")
	Page<Subcategory> findAll(Pageable pageable);
}
