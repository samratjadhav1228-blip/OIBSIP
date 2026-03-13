package com.reservation.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Reservation;
import com.reservation.repository.ReservationRepository;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping("/book")
    public Reservation bookTicket(@RequestBody Reservation reservation){

        String pnr = UUID.randomUUID().toString().substring(0,8);
        reservation.setPnr(pnr);

        return reservationRepository.save(reservation);
    }
}