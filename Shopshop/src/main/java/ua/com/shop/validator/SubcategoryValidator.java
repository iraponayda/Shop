package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.service.SubcategoryService;

public class SubcategoryValidator implements Validator {
	
	private final SubcategoryService subcategoryService;
	
	



	public SubcategoryValidator(SubcategoryService subcategoryService) {
		super();
		this.subcategoryService = subcategoryService;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Subcategory.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Subcategory subcategory = (Subcategory) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can't be empty");
		if(subcategoryService.findUnique(subcategory.getName(), subcategory.getCategory())!=null){
				errors.rejectValue("category", "", "Already exist");
			}
		
	}

}
