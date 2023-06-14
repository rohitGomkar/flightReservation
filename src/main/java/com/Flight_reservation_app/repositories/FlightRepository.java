package com.Flight_reservation_app.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Flight_reservation_app.entities.Flights;

@Repository
public interface FlightRepository extends JpaRepository<Flights, Long> {

	@Query("from Flights where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	public List<Flights> findFlights(@Param("departureCity")String from, @Param("arrivalCity")String to, @Param("dateOfDeparture") Date departureDate);




}
