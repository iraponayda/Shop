package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import dto.ToyForm;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.entity.Toy;
import ua.com.shop.service.ToyService;

public class ToyValidator implements Validator{

	
	
	private final static Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

	
	private final ToyService toyService;
	public ToyValidator(ToyService toyService) {
		this.toyService = toyService;
	}

	public boolean supports(Class<?> clazz) {
		
		return ToyForm.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ToyForm form = (ToyForm) target;
		if(!REG.matcher(form.getName()).matches()){
			errors.rejectValue("name", "", "Enter number with . or , or only numbers");
		}
		if(errors.getFieldError("name")==null){
			if(toyService.findUnique(form.getName(), form.getAge(), form.getGender(), form.getMaterial(), form.getPrice(), form.getSubcategory(), form.getProducer())!=null){
				errors.rejectValue("age", "", "Already exist");
			}
		
		}
	}

	
	
	
	
}
