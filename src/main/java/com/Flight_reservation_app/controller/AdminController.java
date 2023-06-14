package com.Flight_reservation_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_reservation_app.entities.Admin;
import com.Flight_reservation_app.entities.Flights;
import com.Flight_reservation_app.repositories.AdminRepository;
import com.Flight_reservation_app.repositories.FlightRepository;
import com.sun.org.apache.bcel.internal.generic.BASTORE;


@Controller
public class AdminController{
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private AdminRepository adminRepo;

	@RequestMapping("/adminLogin")
	public String loginAdminData() {
		return "login/adminLogin";
		
	}
	
	@RequestMapping("/verifyAdminLogin")
	public String verifyLoginAdmin(@RequestParam("email") String email, @RequestParam("password") String password,ModelMap modelMap) {
	 Admin admin = adminRepo.findByEmail(email);
		if(admin!=null) {
		if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
			return "taskPage";
		} else {
			modelMap.addAttribute("msg","Invalid emailid/password");
			return "login/adminLogin";
		}
		}
		else {
			modelMap.addAttribute("msg","Invalid emailid/password");
			return "login/adminLogin";
		}
	}
	
	@RequestMapping("/showAllFlights")
	public String getAllFlights(ModelMap modelMap) {
		List<Flights> findAll = flightRepo.findAll();
		modelMap.addAttribute("findAll", findAll);
		return "showFlights";
	}
	
	@RequestMapping("/updateFlights")
	public String updateFlights(@RequestParam("flightId")Long flightId,ModelMap modelMap) {
          Optional<Flights> findById = flightRepo.findById(flightId);
          Flights flights = findById.get();
          modelMap.addAttribute("flights", flights);
		return"updateFlights";
	}
	
	
}
