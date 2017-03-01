package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Country;
import ua.com.shop.entity.Gender;
import ua.com.shop.service.GenderService;

public class GenderValidator implements Validator{

	private final GenderService genderService;
	
	
	
	public GenderValidator(GenderService genderService) {

		this.genderService = genderService;
	}

	public boolean supports(Class<?> clazz) {
		
		return Gender.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Gender gender = (Gender)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "", "Can't be empty");
		if(genderService.findByName(gender.getGender())!=null){
			errors.rejectValue("gender", "", "Already exists");
		}
		
	}

	
	
}
