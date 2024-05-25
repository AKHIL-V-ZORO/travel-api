package com.spring.travel.dao;

import com.spring.travel.dto.OrderResponse;
import com.spring.travel.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TripDao extends JpaRepository<Trip,Integer> {

    @Query(" SELECT t.travelerName,t.tripPnr,t.tripStartDate,t.tripEndDate, h.hotelName,h.place,r.roomType, r.roomRate FROM Trip t JOIN t.hotels h JOIN h.rooms r WHERE t.tripStartDate >= :startDate AND t.tripEndDate <= :endDate")
    List<Object> findByTripDatesBetween(LocalDate startDate, LocalDate endDate);
}


//SELECT t FROM Trip t WHERE t.tripStartDate >= :startDate AND t.tripEndDate <= :endDate-feching all data

//SELECT t.travelerName , h.name FROM Trip t JOIN t.hotels h WHERE t.tripStartDate >= :startDate AND t.tripEndDate <= :endDate -fetch dta frm different tables