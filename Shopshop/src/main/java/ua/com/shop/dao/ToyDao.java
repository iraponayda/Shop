package ua.com.shop.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Toy;

public interface ToyDao extends JpaRepository<Toy, Integer>, JpaSpecificationExecutor<Toy>{

	

	List<Toy> findByGenderId(int id);

	@Query("select t from Toy t where t.id=:id")
	List<Toy> findByAgeId(@Param("id")int id);

@Query("SELECT t FROM Toy t LEFT JOIN FETCH t.subcategory LEFT JOIN FETCH t.producer LEFT JOIN FETCH t.gender LEFT JOIN FETCH t.age LEFT JOIN FETCH t.material")
List<Toy> findAll();

@Query("SELECT t FROM Toy t LEFT JOIN FETCH t.subcategory LEFT JOIN FETCH t.producer LEFT JOIN FETCH t.gender LEFT JOIN FETCH t.age LEFT JOIN FETCH t.material WHERE t.id = ?1")
Toy findOne(int id);

@Query("SELECT t FROM Toy t WHERE t.name=?1 and t.age.id=?2 and t.gender.id=?3 and t.material.id=?4 and t.price=?5 and t.subcategory.id=?6 and t.producer.id=?7")
Toy findUnique(String name, int id, int id2, int id3, BigDecimal bigDecimal, int id4, int id5);


//Toy findUnique(String name, int ageId, int genderId, int materialId, BigDecimal big, int subcategoryId, int producerId);

@Query(value="SELECT t FROM Toy t LEFT JOIN FETCH t.producer LEFT JOIN FETCH t.subcategory LEFT JOIN FETCH t.gender LEFT JOIN FETCH t.age LEFT JOIN FETCH t.material",
countQuery="SELECT count(t.id) FROM Toy t")
Page<Toy> findAll(Pageable pageable);

	 
}
