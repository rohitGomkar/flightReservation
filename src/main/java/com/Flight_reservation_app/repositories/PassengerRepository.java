package com.Flight_reservation_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Flight_reservation_app.entities.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
