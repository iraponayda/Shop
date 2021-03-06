package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CategoryDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;
import ua.com.shop.specification.CategorySpecification;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	
	public void save(Category category) {
		// TODO Auto-generated method stub
		categoryDao.save(category);
		
	}

	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	public Category findOne(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findOne(id);
	}

	public void delete(int id) {
		categoryDao.delete(id);
		// TODO Auto-generated method stub
		
	}

	public Category findByName(String name) {
		// TODO Auto-generated method stub
		return categoryDao.findByName(name);
	}

	@Override
	public Page<Category> findAll(Pageable pageable, SimpleFilter filter) {
		
		return categoryDao.findAll(new CategorySpecification(filter), pageable);
	}

}
