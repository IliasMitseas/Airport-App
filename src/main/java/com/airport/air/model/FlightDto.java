package com.airport.air.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
@Getter
@Setter
@EqualsAndHashCode

public class FlightDto {

    private int id;

    private String company;

    private String code;

    private String destination;

    private String flight_time;

    private String gate;

    private String status;


}
