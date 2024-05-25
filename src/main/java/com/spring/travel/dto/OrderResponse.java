package com.spring.travel.dto;

import lombok.Data;


@Data
public class OrderResponse {

    private String travelerName;

    private Integer tripPnr;

    private String hotelName;

    private String place;

    private int roomRate;

    private String roomType;
}
