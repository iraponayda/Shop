package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Category;
import ua.com.shop.entity.Country;
import ua.com.shop.service.CategoryService;

public class CategoryValidator implements Validator{

	private CategoryService categoryService;
	
	
	

	public CategoryValidator(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Category.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Category category = (Category)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can't be empty");
		if(categoryService.findByName(category.getName())!=null){
			errors.rejectValue("name", "", "Already exists");
		}
		
	}

	
}
