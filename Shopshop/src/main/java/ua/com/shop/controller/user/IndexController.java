package ua.com.shop.controller.user;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

import ua.com.shop.entity.Gender;
import ua.com.shop.entity.User;
import ua.com.shop.service.AgeService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.GenderService;
import ua.com.shop.service.ToyService;
import ua.com.shop.service.UserService;
import ua.com.shop.validator.GenderValidator;
import ua.com.shop.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class IndexController {
	
	
	@Autowired
	private UserService userService;


	@InitBinder("user")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new UserValidator(userService));
	}
	
	@ModelAttribute("user")
	public User getForm(){
		return new User();
	}
	
	@GetMapping("/")
	public String index(Principal principal){
		if(principal!=null){
			System.out.println(principal.getName());
			SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		return "user-index";
	}

	
	@GetMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "user-registration";
	}
	
	@PostMapping("/registration")
	public String save(@ModelAttribute("user")@Valid User user, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			return "user-registration";
		}
		userService.save(user);
		status.setComplete();
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(){
		return "user-login";
	}
}
	


	
	
	
	
	

