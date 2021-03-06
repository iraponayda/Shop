package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.ProducerFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;

public class ProducerSpecification implements Specification<Producer>{


	private final ProducerFilter filter;
	
	private final List<Predicate> predicates = new ArrayList<>();
	
	public ProducerSpecification(ProducerFilter filter) {
		this.filter = filter;
	}

	private void filterByCountry(Root<Producer> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getCountryIds().isEmpty()){
			predicates.add(root.get("country").in(filter.getCountryIds()));
		}
	}
	
	
	private void fetch(Root<Producer> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("country");
		}
	}

	

	@Override
	public Predicate toPredicate(Root<Producer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		filterByCountry(root, query, cb);
		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

}
