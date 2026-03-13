package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Reservation;
import com.reservation.repository.ReservationRepository;

@RestController
@RequestMapping("/api/cancel")
@CrossOrigin(origins = "*")
public class CancellationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @DeleteMapping("/{pnr}")
    public String cancelTicket(@PathVariable String pnr){

        Reservation reservation = reservationRepository.findByPnr(pnr);

        if(reservation != null){
            reservationRepository.delete(reservation);
            return "Ticket Cancelled Successfully";
        } else {
            return "PNR Not Found";
        }
    }
}