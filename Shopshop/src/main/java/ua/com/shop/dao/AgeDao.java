package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.Age;


public interface AgeDao extends JpaRepository<Age, Integer>, JpaSpecificationExecutor<Age>{

	Age findByAge(String age);


	
}
