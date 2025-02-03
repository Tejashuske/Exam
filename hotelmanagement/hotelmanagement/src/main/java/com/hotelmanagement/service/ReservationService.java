package com.hotelmanagement.service;

import com.hotelmanagement.model.Reservation;
import com.hotelmanagement.model.Room;
import com.hotelmanagement.repository.ReservationRepository;
import com.hotelmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Reservation createReservation(Reservation reservation) {
        Room room = roomRepository.findById(reservation.getRoom().getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (!room.isAvailability()) {
            throw new RuntimeException("Room is already booked");
        }

        long days = ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
        double totalPrice = days * room.getPrice();

        reservation.setTotalPrice(totalPrice);
        room.setAvailability(false);
        roomRepository.save(room);

        return reservationRepository.save(reservation);
    }

    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        Room room = reservation.getRoom();
        room.setAvailability(true);
        roomRepository.save(room);

        reservationRepository.delete(reservation);
    }
}
