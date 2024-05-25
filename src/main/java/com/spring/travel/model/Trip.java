package com.spring.travel.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer travelerId;

    private String travelerName;


    @Column(unique = true)
    private Integer tripPnr;

    private LocalDate tripStartDate;

    private LocalDate tripEndDate;

    @OneToMany(targetEntity = Hotel.class,cascade = CascadeType.ALL)
    //@JoinColumn(name="forienkey",referencedColumnName = "travelerId")
    private List<Hotel> hotels;

}
