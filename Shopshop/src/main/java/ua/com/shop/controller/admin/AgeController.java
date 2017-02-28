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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.entity.Age;
import ua.com.shop.entity.Country;
import ua.com.shop.service.AgeService;
import ua.com.shop.validator.AgeValidator;
import ua.com.shop.validator.CountryValidator;


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
	
	@ModelAttribute("age")
	public Age getForm(){
		return new Age();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("ages", ageService.findAll());
		return "admin-age";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		ageService.delete(id);
		return "redirect:/admin/age";
	}
	
	@PostMapping
	public String save(@ModelAttribute("age") @Valid Age age, BindingResult br, Model model, SessionStatus status){
		
		if(br.hasErrors()){
			return show(model);
		}
		ageService.save(age);
		status.setComplete();
		return "redirect:/admin/age";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("age", ageService.findOne(id));
		return show(model);
	}

}
