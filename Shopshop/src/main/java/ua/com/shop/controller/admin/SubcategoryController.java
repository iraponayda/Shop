package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.editor.CategoryEditor;
import ua.com.shop.editor.CountryEditor;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Country;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.SubcategoryService;
import ua.com.shop.validator.ProducerValidator;
import ua.com.shop.validator.SubcategoryValidator;



@Controller
@RequestMapping("/admin/subcategory")
@SessionAttributes("subcategory")
public class SubcategoryController {
	@Autowired 
	private CategoryService categoryService;
	
	@Autowired
	private SubcategoryService subcategoryService;
	
	@InitBinder("subcategory")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		
		binder.setValidator(new SubcategoryValidator(subcategoryService));
	}
	
	
	@ModelAttribute("subcategory")
	public Subcategory getForm(){
		return new Subcategory();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("subcategories", subcategoryService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "admin-subcategory";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		subcategoryService.delete(id);
		return "redirect:/admin/subcategory";
	}
	
	@PostMapping
	public String save(@ModelAttribute("subcategory") @Valid Subcategory subcategory, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			return show(model);
		}
		subcategoryService.save(subcategory);
		status.setComplete();
		return "redirect:/admin/subcategory";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("subcategory", subcategoryService.findOne(id));
		return "admin-subcategory";
	}
	
}
