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
import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;
import ua.com.shop.validator.MaterialValidator;
import static ua.com.shop.util.ParamBuilder.*;



@Controller
@RequestMapping("/admin/material")
@SessionAttributes("material")
public class MaterialController {
	@Autowired
	private MaterialService materialService;
	
	@InitBinder("material")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new MaterialValidator(materialService));
	}
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@ModelAttribute("material")
	public Material getForm(){
		return new Material();
	}
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("page", materialService.findAll(pageable, filter));
		return "admin-material";
	}

	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		materialService.delete(id);
		return "redirect:/admin/material"+getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("material") @Valid Material material, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		
		if(br.hasErrors()){
			return show(model, pageable, filter);
		}
		materialService.save(material);
		status.setComplete();

		return "redirect:/admin/material"+getParams(pageable, filter);
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("material", materialService.findOne(id));
		show(model, pageable, filter);
		return "admin-material";
	}

}
