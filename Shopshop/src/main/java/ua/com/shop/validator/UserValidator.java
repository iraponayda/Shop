package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Country;
import ua.com.shop.entity.User;
import ua.com.shop.service.CountryService;
import ua.com.shop.service.UserService;

public class UserValidator implements Validator{
	
	private final UserService userService;

	

	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		User user = (User)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "Can't be empty");
		if(userService.findByEmail(user.getEmail())!=null){
			errors.rejectValue("email", "", "Already exists");
		}
		
	}

}