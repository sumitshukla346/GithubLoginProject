package com.example.loginform.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.loginform.domain.User;
import com.example.loginform.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public ModelAndView login() {
		
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user")  User user) {
		User oauthUser = userService.login(user.getUsername(), user.getPassword());
		System.out.println(oauthUser);
		if(Objects.nonNull(oauthUser)) {
			
			return "redirect:/";
		}else {
			return "redirect:/login";
		}
	}
	@RequestMapping("/active")
	public String active() {
		return"active";
	}

}
