package ua.com.shop.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import ua.com.shop.entity.Toy;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		List<Toy> toys = manager.createQuery("Select t from Toy t JOIN t.producer p WHERE p.name =:name", Toy.class).setParameter("name", "Mattel").getResultList();
		Toy toy = (Toy) manager.createNamedQuery("findByPrice").setParameter("price",  "123").getSingleResult();
		
		System.out.println("toy");
		
		BigDecimal max = manager.createQuery("SELECT max(toy.price) from Toy toy",BigDecimal.class).getSingleResult();
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

}
