package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import ua.com.shop.entity.Gender;
import ua.com.shop.service.GenderService;

@Controller
@RequestMapping("/admin/gender")
@SessionAttributes("gender")
public class GenderController {
	
	@Autowired
	private GenderService genderService;
	
	@ModelAttribute("gender")
	public Gender getForm(){
		return new Gender();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("genders", genderService.findAll());
		return "admin-gender";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		genderService.delete(id);
		return "redirect:/admin/gender";
	}
	
	@PostMapping
	public String save(@ModelAttribute("gender") Gender gender, SessionStatus status){
		genderService.save(gender);
		status.setComplete();
		return "redirect:/admin/gender";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("gender", genderService.findOne(id));
		return show(model);
	}
	

}
