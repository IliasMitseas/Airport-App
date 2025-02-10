package com.airport.air.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "flightdto")
public class FlightDto {


    @Column
    @Id
    private int id;

    @Column
    private String destination;

    @Column
    private String code;

    @Column
    private String gate;

    @Column
    private String flight_time;

    @Column
    private String status;

    @Column
    private String company;
}
