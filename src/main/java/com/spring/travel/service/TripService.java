package com.spring.travel.service;

import com.spring.travel.dao.TripDao;
import com.spring.travel.dto.OrderResponse;
import com.spring.travel.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

   private final TripDao tripDao;
   @Autowired
   public TripService(TripDao tripDao){
       this.tripDao=tripDao;
   }

    public ResponseEntity<List<Trip>> getAllTrips() {
        try {
            return new ResponseEntity<>(tripDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Object>> findAllTripsBetweenDates(LocalDate startDate, LocalDate endDate) {
        try {
            List<Object> trips = tripDao.findByTripDatesBetween(startDate,endDate);
            return new ResponseEntity<>(trips, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addTrip(Trip trip) {
        try {
            tripDao.save(trip);
            return new ResponseEntity<>("trip added successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("failed to add trip", HttpStatus.BAD_REQUEST);
        }
    }
}
