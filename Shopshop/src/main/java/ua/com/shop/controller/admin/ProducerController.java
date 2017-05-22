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

import ua.com.shop.editor.CountryEditor;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Country;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.service.CountryService;
import ua.com.shop.service.ProducerService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.ProducerValidator;
import static ua.com.shop.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/producer")
@SessionAttributes("producer")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private CountryService countryService;
	
	
	@InitBinder("producer")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		
		binder.setValidator(new ProducerValidator(producerService));
	}
	@ModelAttribute("filter")
	public ProducerFilter getFilter(){
		return new ProducerFilter();
	}
	
	@ModelAttribute("producer")
	public Producer getForm(){
		return new Producer();
	}
	

	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ProducerFilter filter){
		model.addAttribute("page", producerService.findAll(pageable, filter));
		model.addAttribute("countries", countryService.findAll());
		return "admin-producer";
	}

	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") ProducerFilter filter){
		producerService.delete(id);
		return "redirect:/admin/producer"+getParams(pageable, filter);
	}

	@PostMapping	
	public String save(@ModelAttribute("producer") @Valid Producer producer, BindingResult br, Model model, SessionStatus status,  @PageableDefault Pageable pageable, @ModelAttribute("filter") ProducerFilter filter){
		if(br.hasErrors()){
			return show(model, pageable, filter);
		}
		producerService.save(producer);
		status.setComplete();
		return "redirect:/admin/producer"+getParams(pageable, filter);
	}
	

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ProducerFilter filter){
		model.addAttribute("producer", producerService.findOne(id));
		return show(model, pageable, filter);
	}

	private String getParams(Pageable pageable, ProducerFilter filter){
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		
		if(!filter.getCountryIds().isEmpty()){
			for (int id : filter.getCountryIds()) {
				buffer.append("&countryIds=");
				buffer.append(id);
			}
		}
		
		return buffer.toString();
	}
	

}
