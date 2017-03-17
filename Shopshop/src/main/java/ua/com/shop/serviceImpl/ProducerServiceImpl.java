package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ProducerDao;
import ua.com.shop.dto.filter.ProducerFilter;
import ua.com.shop.entity.Country;
import ua.com.shop.entity.Producer;
import ua.com.shop.service.ProducerService;
import ua.com.shop.specification.CountrySpecification;
import ua.com.shop.specification.ProducerSpecification;
@Service
public class ProducerServiceImpl implements ProducerService {

	
	@Autowired
	private ProducerDao producerDao;
	

	public List<Producer> findAll() {
		// TODO Auto-generated method stub
		return producerDao.findAll();
	}

	public Producer findOne(int id) {
		// TODO Auto-generated method stub
		return producerDao.findOne(id);
	}

	public void delete(int id) {
		producerDao.delete(id);// TODO Auto-generated method stub
		
	}
	
	

	public Producer findUnique(String name, Country country) {
		// TODO Auto-generated method stub
		return producerDao.findUnique(name, country.getId());
	}

	public void save(Producer producer) {
		producerDao.save(producer);
		
	}

	@Override
	public Page<Producer> findAll(Pageable pageable, ProducerFilter filter) {
		return producerDao.findAll(new ProducerSpecification(filter), pageable);
	}
	


	
	
}
