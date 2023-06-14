package com.Flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_reservation_app.entities.User;
import com.Flight_reservation_app.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showLoginPage")
	public String saveUserData() {
		return "login/login";
	}

	@RequestMapping("/saveUser")
	public String saveUser() {
		return "login/saveUser";
	}

	@RequestMapping("/saveUserData")
	public String saveUserData(@ModelAttribute("user") User user, ModelMap modelMap) {
		userRepo.save(user);
		return "login/login";
	}

	@RequestMapping("/login")
	public String verifyLoginUser(@RequestParam("email") String email, @RequestParam("password") String password,ModelMap modelMap) {
		User user = userRepo.findByEmail(email);
		if(user!=null) {
		if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
			return "searchFlight";
		} else {
			modelMap.addAttribute("msg","Invalid emailid/password");
			return "login/login";
		}
		}
		else {
			modelMap.addAttribute("msg","Invalid emailid/password");
			return "login/login";
		}
	}
	
}
