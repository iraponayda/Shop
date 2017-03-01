package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Age;
import ua.com.shop.entity.Country;
import ua.com.shop.service.AgeService;

public class AgeValidator implements Validator{

	private final AgeService ageService;
	
	
	
	public AgeValidator(AgeService ageService) {
		this.ageService = ageService;
	}
	

	public boolean supports(Class<?> clazz) {
		
		return Age.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Age age = (Age)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "", "Can't be empty");
		if(ageService.findByName(age.getAge())!=null){
			errors.rejectValue("age", "", "Already exists");
		}
		
	}

}
