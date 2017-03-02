package ua.com.shop.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


@NamedQuery(name = "findByPrice", query = "select t from Toy t where t.price =:price")


@Entity
public class Toy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private BigDecimal price;
		
	@ManyToOne(fetch=FetchType.LAZY)
	private Producer producer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Subcategory subcategory;
	

	@ManyToOne(fetch=FetchType.LAZY)
	private Age age;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Gender gender;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Material material;
	
	@ManyToMany
	@JoinTable(name = "toy_user", joinColumns=@JoinColumn(name = "id_toy"), inverseJoinColumns= @JoinColumn(name = "id_user"))
	private List<User> users;
	
	public Toy() {
		
		
		
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

	public void setName(String name) {
		this.name = name;
	}


	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}



	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
	
	
	
	
}
