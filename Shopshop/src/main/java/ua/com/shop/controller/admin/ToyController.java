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

import dto.ToyForm;
import ua.com.shop.editor.AgeEditor;
import ua.com.shop.editor.GenderEditor;
import ua.com.shop.editor.MaterialEditor;
import ua.com.shop.editor.ProducerEditor;
import ua.com.shop.editor.SubcategoryEditor;
import ua.com.shop.entity.Age;
import ua.com.shop.entity.Gender;
import ua.com.shop.entity.Material;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Subcategory;
import ua.com.shop.entity.Toy;
import ua.com.shop.service.AgeService;
import ua.com.shop.service.GenderService;
import ua.com.shop.service.MaterialService;
import ua.com.shop.service.ProducerService;
import ua.com.shop.service.SubcategoryService;
import ua.com.shop.service.ToyService;
import ua.com.shop.validator.ToyValidator;

@Controller
@RequestMapping("/admin/toy")
@SessionAttributes("toy")
public class ToyController {
	
	@Autowired
	private ToyService toyService;
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private SubcategoryService subcategoryService;
	
	@Autowired
	private GenderService genderService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private AgeService ageService;
	
	
	
	
	@InitBinder("toy")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		binder.registerCustomEditor(Subcategory.class, new SubcategoryEditor(subcategoryService));
		binder.registerCustomEditor(Gender.class, new GenderEditor(genderService));
		binder.registerCustomEditor(Material.class, new MaterialEditor(materialService));
		binder.registerCustomEditor(Age.class, new AgeEditor(ageService));
		binder.setValidator(new ToyValidator(toyService));
	}
	
	@ModelAttribute("toy")
	public ToyForm getForm(){
		return new ToyForm();
	}
	
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("toys", toyService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("subcategories", subcategoryService.findAll());
		model.addAttribute("genders", genderService.findAll());
		model.addAttribute("ages", ageService.findAll());
		model.addAttribute("materials", materialService.findAll());
		return "admin-toy";
		
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		toyService.delate(id);
		return "redirect:/admin/toy";
	}
	
	@PostMapping
	public String save(@ModelAttribute("toy") @Valid ToyForm toy, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()) return show(model);
		toyService.save(toy);
		status.setComplete();
		return "redirect:/admin/toy";
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("toy", toyService.findForm(id));
		return show(model);
	}
	

}
