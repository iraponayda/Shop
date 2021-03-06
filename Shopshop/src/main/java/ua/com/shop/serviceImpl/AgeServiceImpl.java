package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.AgeDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Age;
import ua.com.shop.service.AgeService;
import ua.com.shop.specification.AgeSpecification;

@Service
public class AgeServiceImpl implements AgeService{
	
	@Autowired
	private AgeDao ageDao;
	
	public void save(Age age) {
		ageDao.save(age);
		
	}

	public List<Age> findAll() {
		// TODO Auto-generated method stub
		return ageDao.findAll();
	}

	public Age findOne(int id) {
		// TODO Auto-generated method stub
		return ageDao.findOne(id);
	}

	public void delete(int id) {
		ageDao.delete(id);
		
	}
	public void update(Age age){
		ageDao.save(age);
	}

	public Age findByName(String age) {
		// TODO Auto-generated method stub
		return ageDao.findByAge(age);
	}

	@Override
	public Page<Age> findAll(Pageable pageable, SimpleFilter filter) {
		// TODO Auto-generated method stub
		return ageDao.findAll(new AgeSpecification(filter), pageable);
	}



}

