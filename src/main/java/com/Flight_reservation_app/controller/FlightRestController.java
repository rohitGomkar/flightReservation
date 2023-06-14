package com.Flight_reservation_app.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Flight_reservation_app.entities.Reservation;
import com.Flight_reservation_app.repositories.ReservationRepository;

@RestController
public class FlightRestController {

@Autowired
private ReservationRepository reservationRpo;

@GetMapping("/reservation/{id}")
public Reservation getReservation(@PathVariable("id")Long id) {
	Optional<Reservation> findById = reservationRpo.findById(id);
	Reservation reservation = findById.get();
	
	return reservation;
	
}

}
