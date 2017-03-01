package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.SubcategoryDao;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.service.SubcategoryService;
@Service
public class SubcategoryServiceImpl implements SubcategoryService{

	@Autowired
	private SubcategoryDao subcategoryDao;
	
	public void save(Subcategory subcategory) {
		subcategoryDao.save(subcategory);// TODO Auto-generated method stub
		
	}

	public List<Subcategory> findAll() {
		// TODO Auto-generated method stub
		return subcategoryDao.findAll();
	}

	public Subcategory findOne(int id) {
		// TODO Auto-generated method stub
		return subcategoryDao.findOne(id);
	}

	public void delete(int id) {
		subcategoryDao.delete(id);// TODO Auto-generated method stub
		
	}

	public Subcategory findUnique(String name, Category category) {
		// TODO Auto-generated method stub
		return subcategoryDao.findUnique(name, category.getId());
	}

}
