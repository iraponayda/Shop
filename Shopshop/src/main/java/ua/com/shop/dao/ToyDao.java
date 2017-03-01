package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Toy;

public interface ToyDao extends JpaRepository<Toy, Integer>{

	

	List<Toy> findByGenderId(int id);

	@Query("select t from Toy t where t.id=:id")
	List<Toy> findByAgeId(@Param("id")int id);

@Query("SELECT t FROM Toy t LEFT JOIN FETCH t.subcategory LEFT JOIN FETCH t.producer LEFT JOIN FETCH t.gender LEFT JOIN FETCH t.age LEFT JOIN FETCH t.material")
List<Toy> findAll();

@Query("SELECT t FROM Toy t LEFT JOIN FETCH t.subcategory LEFT JOIN FETCH t.producer LEFT JOIN FETCH t.gender LEFT JOIN FETCH t.age LEFT JOIN FETCH t.material WHERE t.id = ?1")
Toy findOne(int id);

@Query("SELECT t FROM Toy t WHERE t.name=?1 and t.age.id=?2 and t.gender.id=?3 and t.material.id=?4 and t.price=?5 and t.subcategory.id=?6 and t.producer.id=?7")
Toy findUnique(String name, int ageId, int genderId, int materialId, Double double1, int subcategoryId, int producerId);

	 
}
