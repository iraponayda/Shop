package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.shop.editor.CategoryEditor;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.SubcategoryService;



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
	public String save(@ModelAttribute("subcategory") Subcategory subcategory){
		subcategoryService.save(subcategory);
		return "redirect:/admin/subcategory";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("subcategory", subcategoryService.findOne(id));
		return "admin-subcategory";
	}
	
}
