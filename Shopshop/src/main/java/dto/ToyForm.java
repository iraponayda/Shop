package dto;



import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import ua.com.shop.entity.Age;
import ua.com.shop.entity.Gender;
import ua.com.shop.entity.Material;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;

public class ToyForm {
	
	private int id;
	private String name;
	private String price;
	private Subcategory subcategory;
	private Age age;
	private Gender gender;
	private Material material;
	private Producer producer;
	
	private int version;
	
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Subcategory getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}
	public Age getAge() {
		return age;
	}
	public void setAge(Age age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}

	
}
