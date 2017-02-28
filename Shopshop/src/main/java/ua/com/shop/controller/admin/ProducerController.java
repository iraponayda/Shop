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


import ua.com.shop.editor.CountryEditor;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Country;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.service.CountryService;
import ua.com.shop.service.ProducerService;
import ua.com.shop.validator.ProducerValidator;

@Controller
@RequestMapping("/admin/producer")
@SessionAttributes("producer")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private CountryService countryService;
	
	@ModelAttribute("producer")
	public Producer getForm(){
		return new Producer();
	}
	@InitBinder("producer")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		
		binder.setValidator(new ProducerValidator(producerService));
	}
	
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "admin-producer";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		producerService.delete(id);
		return "redirect:/admin/producer";
	}

	@PostMapping	
	public String save(@ModelAttribute("producer") @Valid Producer producer, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			return show(model);
		}
		producerService.save(producer);
		status.setComplete();
		return "redirect:/admin/producer";
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("producer", producerService.findOne(id));
		return show(model);
	}


}
