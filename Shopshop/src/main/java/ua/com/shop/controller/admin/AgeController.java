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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Age;
import ua.com.shop.entity.Country;
import ua.com.shop.service.AgeService;
import ua.com.shop.validator.AgeValidator;
import ua.com.shop.validator.CountryValidator;
import static ua.com.shop.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/age")
@SessionAttributes("age")
public class AgeController {
	@Autowired
	private AgeService ageService;
	
	@InitBinder("age")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new AgeValidator(ageService));
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@ModelAttribute("age")
	public Age getForm(){
		return new Age();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("page", ageService.findAll(pageable, filter));
		return "admin-age";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		ageService.delete(id);
		return "redirect:/admin/age"+getParams(pageable, filter);
	}
	

	
	@PostMapping
	public String save(@ModelAttribute("age") @Valid Age age, BindingResult br, Model model, SessionStatus status,  @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		
		if(br.hasErrors()){
			return show(model, pageable, filter);
		}
		ageService.save(age);
		status.setComplete();
		return "redirect:/admin/age"+getParams(pageable, filter);
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("age", ageService.findOne(id));
		show(model, pageable, filter);
		return "admin-age";
	}
	

}
