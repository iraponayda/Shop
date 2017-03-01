package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Country;
import ua.com.shop.service.CountryService;


public class CountryValidator implements Validator{
	
	private final CountryService countryService;
	
	public CountryValidator(CountryService countryService) {
		this.countryService = countryService;
	}
	
	

	public boolean supports(Class<?> clazz) {
		return Country.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Country country = (Country)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can't be empty");
		if(countryService.findByName(country.getName())!=null){
			errors.rejectValue("name", "", "Already exists");
		}
		
	}

}
