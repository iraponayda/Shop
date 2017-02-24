package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.MaterialDao;
import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;
@Service
public class MaterialServiceImpl implements MaterialService {

		@Autowired
		private MaterialDao materialDao;
		
	public void save(Material material) {
		materialDao.save(material);
		
	}

	public List<Material> findAll() {
		// TODO Auto-generated method stub
		return materialDao.findAll();
	}

	public Material findOne(int id) {
		// TODO Auto-generated method stub
		return materialDao.findOne(id);
	}

	public void delete(int id) {
		materialDao.delete(id);// TODO Auto-generated method stub
		
	}

}
