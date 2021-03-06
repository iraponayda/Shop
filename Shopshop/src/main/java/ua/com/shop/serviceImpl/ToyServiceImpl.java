package ua.com.shop.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dto.ToyForm;
import ua.com.shop.dao.AgeDao;
import ua.com.shop.dao.ToyDao;
import ua.com.shop.dto.filter.ToyFilter;
import ua.com.shop.entity.Age;
import ua.com.shop.entity.Gender;
import ua.com.shop.entity.Material;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.entity.Toy;
import ua.com.shop.service.FileWriter;
import ua.com.shop.service.ToyService;
import ua.com.shop.specification.ToySpecification;
import ua.com.shop.service.FileWriter.Folder;

@Service
public class ToyServiceImpl implements ToyService {

	@Autowired
	private ToyDao toyDao;
	
	@Autowired AgeDao ageDao;
	
	@Autowired
	private FileWriter fileWriter;
	
	

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

	public Toy findUnique(String name, Age age, Gender gender, Material material, String price,
			Subcategory subcategory, Producer producer) {
		
		return toyDao.findUnique(name, age.getId(), gender.getId(), material.getId(), new BigDecimal(price.replace(',', '.')), subcategory.getId(), producer.getId());
	}


	
	
	@Override
	public void save(ToyForm form) {
		Toy entity = new Toy();
		
		MultipartFile file = form.getFile();
		entity = toyDao.saveAndFlush(entity);
		if(fileWriter.write(Folder.TOY, file, form.getId())){
			entity.setVersion(form.getVersion()+1);
			entity.setName(form.getName());
			entity.setAge(form.getAge());
			entity.setGender(form.getGender());
			entity.setMaterial(form.getMaterial());
			entity.setPrice(new BigDecimal(form.getPrice().replace(',', '.')));
			entity.setSubcategory(form.getSubcategory());
			entity.setProducer(form.getProducer());
			toyDao.save(entity);
		}
	
		
	}

	public ToyForm findForm(int id) {
		ToyForm form = new ToyForm();
		Toy entity = toyDao.findOne(id);
		form.setName(entity.getName());
		form.setAge(entity.getAge());
		form.setGender(entity.getGender());
		form.setMaterial(entity.getMaterial());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setSubcategory(entity.getSubcategory());
		form.setProducer(entity.getProducer());
		form.setId(entity.getId());
		return form;
	}

	@Override
	public Page<Toy> findAll(Pageable pageable, ToyFilter filter) {
		
		return toyDao.findAll(new ToySpecification(filter), pageable);
	}

}
