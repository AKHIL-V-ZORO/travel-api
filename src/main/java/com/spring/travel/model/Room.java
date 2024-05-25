package com.spring.travel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    private int roomId;

    @Column(unique = true)
    private int roomNumber;

    private int roomRate;

    private String roomType;

}
