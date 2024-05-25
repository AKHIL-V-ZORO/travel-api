package com.spring.travel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Hotel {
    @Id
    private int hotelId;

    private String hotelName;

    private String place;

    @OneToMany(targetEntity = Room.class,cascade = CascadeType.ALL)
    private List<Room> rooms;
}
