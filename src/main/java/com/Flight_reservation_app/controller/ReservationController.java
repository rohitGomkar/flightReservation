package com.Flight_reservation_app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_reservation_app.entities.Flights;
import com.Flight_reservation_app.entities.Passenger;
import com.Flight_reservation_app.entities.Reservation;
import com.Flight_reservation_app.repositories.FlightRepository;
import com.Flight_reservation_app.repositories.PassengerRepository;
import com.Flight_reservation_app.repositories.ReservationRepository;
import com.Flight_reservation_app.util.EmailService;
import com.Flight_reservation_app.util.PdfGenerator;

@Controller
public class ReservationController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private PassengerRepository passengerRepo;

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PdfGenerator pdfGen;

	@RequestMapping("/confirmReservation")
	public String confirmReservation(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("middleName") String middleName,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("flightId") Long flightId, ModelMap modelMap) {

		Passenger passenger = new Passenger();
		passenger.setFirstName(firstName);
		passenger.setLastName(lastName);
		passenger.setMiddleName(middleName);
		passenger.setEmail(email);
		passenger.setPhone(phone);

		passengerRepo.save(passenger);

		Optional<Flights> findById = flightRepo.findById(flightId);
		Flights flights = findById.get();

		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservation.setPassenger(passenger);
		reservation.setFlights(flights);

		String filePath = "C:\\Users\\rohit\\Documents\\workspace-spring-tool-suite-4-4.7.2.RELEASE\\Flight_reservation_app\\tickets\\"+"tickets" + passenger.getId() + ".pdf";
		reservationRepo.save(reservation);

	pdfGen.generateItinerary(filePath, reservation);
	emailService.sendEmail(passenger.getEmail(), filePath);

		modelMap.addAttribute("firstName", firstName);
		modelMap.addAttribute("laststName", lastName);
		modelMap.addAttribute("middleName", middleName);
		modelMap.addAttribute("email", email);
		modelMap.addAttribute("phone", phone);
		modelMap.addAttribute("operatingAirlines", flights.getOperatingAirlines());
		modelMap.addAttribute("departureCity", flights.getDepartureCity());
		modelMap.addAttribute("arrivalCity", flights.getArrivalCity());
		modelMap.addAttribute("estimatedDepartureTime", flights.getEstimatedDepartureTime());

		return "confirmationPage";

	}
}
