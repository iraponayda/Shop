package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import ua.com.shop.dto.filter.ProducerFilter;
import ua.com.shop.dto.filter.SubcategoryFilter;
import ua.com.shop.editor.CategoryEditor;
import ua.com.shop.editor.CountryEditor;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Country;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.SubcategoryService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.ProducerValidator;
import ua.com.shop.validator.SubcategoryValidator;
import static ua.com.shop.util.ParamBuilder.*;



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
	@ModelAttribute("filter")
	public SubcategoryFilter getFilter(){
		return new SubcategoryFilter();
	}
	
	@ModelAttribute("subcategory")
	public Subcategory getForm(){
		return new Subcategory();
	}
	


	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		model.addAttribute("page", subcategoryService.findAll(pageable, filter));
		model.addAttribute("categories", categoryService.findAll());
		return "admin-subcategory";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		subcategoryService.delete(id);
		return "redirect:/admin/subcategory"+getParams(pageable, filter);
	}
	
	
	@PostMapping
	public String save(@ModelAttribute("subcategory") @Valid Subcategory subcategory, BindingResult br, Model model, SessionStatus status,  @PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		if(br.hasErrors()){
			return show(model, pageable, filter);
		}
		subcategoryService.save(subcategory);
		status.setComplete();
		return "redirect:/admin/subcategory"+getParams(pageable, filter);
	}
	

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SubcategoryFilter filter){
		model.addAttribute("subcategory", subcategoryService.findOne(id));
		return show(model, pageable, filter);
	}

	private String getParams(Pageable pageable, SubcategoryFilter filter){
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		
		if(!filter.getCategoryIds().isEmpty()){
			for (int id : filter.getCategoryIds()) {
				buffer.append("&categoryIds=");
				buffer.append(id);
			}
		}
		
		return buffer.toString();
	}
	
	
}
