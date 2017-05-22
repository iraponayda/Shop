package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.ToyFilter;
import ua.com.shop.entity.Toy;

public class ToySpecification implements Specification<Toy>{

	private final ToyFilter filter;
	
	private final List<Predicate> predicates = new ArrayList<>();
	
	
	
	public ToySpecification(ToyFilter filter) {
		this.filter = filter;
	}
	
	private void filterByProducer(Root<Toy> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getProducerIds().isEmpty()){
			predicates.add(root.get("producer").in(filter.getProducerIds()));
		}
	}
	private void filterBySubcategory(Root<Toy> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getProducerIds().isEmpty()){
			predicates.add(root.get("producer").in(filter.getProducerIds()));
		}
	}
	private void filterByGender(Root<Toy> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getGenderIds().isEmpty()){
			predicates.add(root.get("gender").in(filter.getGenderIds()));
		}
	}
	private void filterByAge(Root<Toy> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getAgeIds().isEmpty()){
			predicates.add(root.get("age").in(filter.getAgeIds()));
		}
	}
	private void filterByMaterial(Root<Toy> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getMaterialIds().isEmpty()){
			predicates.add(root.get("material").in(filter.getMaterialIds()));
		}
	}

	private void fetch(Root<Toy> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("producer");
			root.fetch("subcategory");
			root.fetch("gender");
			root.fetch("age");
			root.fetch("material");
		}
	}

	@Override
	public Predicate toPredicate(Root<Toy> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		filterByProducer(root, query, cb);
		filterBySubcategory(root, query, cb);
		filterByGender(root, query, cb);
		filterByAge(root, query, cb);
		filterByMaterial(root, query, cb);
		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

}
