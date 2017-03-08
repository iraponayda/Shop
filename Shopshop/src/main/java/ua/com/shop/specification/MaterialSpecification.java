package ua.com.shop.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Age;
import ua.com.shop.entity.Material;

public class MaterialSpecification implements Specification<Material> {
private final SimpleFilter filter;
	
	public MaterialSpecification(SimpleFilter filter) {
		this.filter = filter;
	}

	

	@Override
	public Predicate toPredicate(Root<Material> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(filter.getSearch().isEmpty())return null;
		return cb.like(cb.lower(root.get("material")), filter.getSearch().toLowerCase()+"%");
	}


}
