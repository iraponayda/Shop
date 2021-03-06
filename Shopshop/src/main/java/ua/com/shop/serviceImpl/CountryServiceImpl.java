package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CountryDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Country;
import ua.com.shop.service.CountryService;
import ua.com.shop.specification.CountrySpecification;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;

	public void save(Country country) {
		countryDao.save(country);

	}

	public Country findOne(int id) {
		// TODO Auto-generated method stub
		return countryDao.findOne(id);
	}

	public void delete(int id) {
		countryDao.delete(id);// TODO Auto-generated method stub

	}

	public List<Country> findAll() {
		// TODO Auto-generated method stub
		return countryDao.findAll();
	}

	public Country findByName(String name) {
		
		return countryDao.findByName(name);
	}

	@Override
	public Page<Country> findAll(Pageable pageable, SimpleFilter filter) {
		
		return countryDao.findAll(new CountrySpecification(filter), pageable);
	}

}
