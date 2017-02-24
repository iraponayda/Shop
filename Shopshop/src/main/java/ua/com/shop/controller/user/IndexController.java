package ua.com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.service.AgeService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.GenderService;
import ua.com.shop.service.ToyService;

@Controller
public class IndexController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ToyService toyService;
	
	@Autowired
	private GenderService genderService;
	
	@Autowired
	private AgeService ageService;

	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("categories", categoryService.findAll());
		return "user-index";
	}
	

	
	@RequestMapping("/gender/{id}")
	public String gender(@PathVariable int id, Model model){
		model.addAttribute("gender", genderService.findOne((id)));
		model.addAttribute("toys", toyService.findByGenderId(id));
		return "user-gender";
	}
	@RequestMapping("/gender")
	public String gender1(Model model){
		model.addAttribute("genders", genderService.findAll());
		return "user-gender";
	}
	@RequestMapping("/age")
	public String age(Model model){
		model.addAttribute("ages", ageService.findAll());
		return "user-age";
	}
	
	@RequestMapping("/age/{id}")
	public String age1(@PathVariable int id, Model model){
		model.addAttribute("age", ageService.findAll());
		model.addAttribute("toys", toyService.findByAgeId(id));
		return "user-age";
	}
	

	
	@RequestMapping("/toy")
	public String some3(){
		return "admin-toy";
	}
	@RequestMapping("/category")
	public String some4(){
		return "user-category";
	}
	
	@RequestMapping("/cars")
	public String some5(){
		return "admin-cars";
	}
	
	@RequestMapping("/softToys")
	public String some6(){
		return "admin-softToys";
	}
	
	@RequestMapping("/puzzles")
	public String some7(){
		return "admin-puzzles";
	}
	
	@RequestMapping("/books")
	public String some8(){
		return "admin-books";
	}
	
	@RequestMapping("/dolls")
	public String some9(){
		return "admin-dolls";
	}
	@RequestMapping("/admin/producer")
	public String some10(){
		return "admin-producer";
	}
	@RequestMapping("/admin/category")
	public String some11(){
		return "admin-category";
	}
	@RequestMapping("/admin/subcategory")
	public String some12(){
		return "admin-subcategory";
	}
	@RequestMapping("/admin/gender")
	public String some13(){
		return "admin-gender";
	}
	
	@RequestMapping("/admin/toy")
	public String some14(){
		return "admin-toy";
	}

	
	
	
	
	
}
