package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Age;
import ua.com.shop.service.AgeService;

public class AgeEditor extends PropertyEditorSupport{
	
	private final AgeService ageService;

	public AgeEditor(AgeService ageService) {
		
		this.ageService = ageService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Age age = ageService.findOne(Integer.valueOf(text));
		setValue(age);
	}

	

	
}
