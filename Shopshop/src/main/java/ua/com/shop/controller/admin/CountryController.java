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

import ua.com.shop.entity.Country;
import ua.com.shop.service.CountryService;
import ua.com.shop.validator.CountryValidator;



@Controller
@RequestMapping("/admin/country")
@SessionAttributes("country")
public class CountryController {
	@Autowired
	private CountryService countryService;
	
	
	@InitBinder("country")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new CountryValidator(countryService));
	}
	
	
	@ModelAttribute("country")
	public Country getForm(){
		return new Country();
	}
	
	
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("countries", countryService.findAll());
		return "admin-country";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		countryService.delete(id);
		return "redirect:/admin/country";
	}
	
	@PostMapping
	public String save(@ModelAttribute("country") @Valid Country country, BindingResult br, Model model, SessionStatus status){
		
		if(br.hasErrors()){
			return show(model);
		}
		countryService.save(country);
		status.setComplete();
		return "redirect:/admin/country";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("country", countryService.findOne(id));
		return show(model);
	}

}
