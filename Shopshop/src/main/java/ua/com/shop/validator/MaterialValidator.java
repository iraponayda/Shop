package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import ua.com.shop.entity.Gender;
import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;

public class MaterialValidator implements Validator{

	private final MaterialService materialService;
	
	
	
	public MaterialValidator(MaterialService materialService) {
		
		this.materialService = materialService;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Material.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Material material = (Material)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "material", "", "Can't be empty");
		if(materialService.findByMaterial(material.getMaterial())!=null){
			errors.rejectValue("material", "", "Already exists");
		}
		}

}
