 package com.Flight_reservation_app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_reservation_app.entities.Flights;
import com.Flight_reservation_app.repositories.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepo;

	@RequestMapping("/searchFlightPage")
	public String searchFlight(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
			ModelMap modelMap) {
		List<Flights> findFlights = flightRepo.findFlights(from, to, departureDate);
		modelMap.addAttribute("findFlights", findFlights);

		return "displayFlights";
	}

	@RequestMapping("/selectFlight")
	public String selectFlights(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Optional<Flights> findById = flightRepo.findById(flightId);
		Flights flight = findById.get();
		modelMap.addAttribute("flight", flight);
		return "reservationPage";
	}

}