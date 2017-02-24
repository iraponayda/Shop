package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Subcategory;
import ua.com.shop.service.SubcategoryService;

public class SubcategoryEditor extends PropertyEditorSupport{
	private final SubcategoryService subcategoryService;

	public SubcategoryEditor(SubcategoryService subcategoryService) {
		this.subcategoryService = subcategoryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Subcategory subcategory = subcategoryService.findOne(Integer.valueOf(text));
		setValue(subcategory);
	}
	
}
