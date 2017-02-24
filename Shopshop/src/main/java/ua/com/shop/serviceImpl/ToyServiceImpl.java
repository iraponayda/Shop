package ua.com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.AgeDao;
import ua.com.shop.dao.ToyDao;
import ua.com.shop.entity.Age;
import ua.com.shop.entity.Toy;
import ua.com.shop.service.ToyService;

@Service
public class ToyServiceImpl implements ToyService {

	@Autowired
	private ToyDao toyDao;
	
	@Autowired AgeDao ageDao;
	
	public void save(Toy toy) {
		toy.getName().toLowerCase();
		toyDao.save(toy);
		
	}

	public List<Toy> findAll() {
		
		return toyDao.findAll();
	}

	public Toy findOne(int id) {
		// TODO Auto-generated method stub
		return toyDao.findOne(id);
	}

	public void delate(int id) {
		toyDao.delete(id);
		
	}
	public void update(Toy toy){
		toyDao.save(toy);
	}
	public void addAgeToToy(int idToy, int idAge){
		Toy toy = toyDao.findOne(idToy);
		Age age = ageDao.findOne(idAge);
		toyDao.save(toy);
	}



	public List<Toy> findByGenderId(int id) {
		// TODO Auto-generated method stub
		return toyDao.findByGenderId(id);
	}

	public List<Toy> findByAgeId(int id) {
		// TODO Auto-generated method stub
		return toyDao.findByAgeId(id);
	}

}
