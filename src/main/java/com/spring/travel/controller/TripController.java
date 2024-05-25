package com.spring.travel.controller;


import com.spring.travel.dto.OrderResponse;
import com.spring.travel.model.Trip;
import com.spring.travel.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("trip")
public class TripController {

    private final TripService tripService;
    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("allTrips")
    public ResponseEntity<List<Trip>> getAllTrip() {
        return tripService.getAllTrips();
    }

    @GetMapping("findtrips")
    public ResponseEntity<List<Object>> findAllTrips(
            @RequestParam(value = "startDate")  LocalDate startDate,
            @RequestParam(value = "endDate") LocalDate endDate) {

        return tripService.findAllTripsBetweenDates(startDate,endDate);
    }

    @PostMapping("addTrip")
    public ResponseEntity<String> addTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }
}
