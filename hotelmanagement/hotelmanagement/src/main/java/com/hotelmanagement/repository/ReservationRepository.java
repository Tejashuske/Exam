package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
