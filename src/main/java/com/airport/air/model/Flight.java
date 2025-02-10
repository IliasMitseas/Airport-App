package com.airport.air.model;
import com.airport.air.service.FlightService;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "flight")
public class Flight {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String destination;

    @Column
    private String code;

    @Column
    private String gate;

    @Column
    private LocalTime flight_time;

    @Column
    private String status;


    @Column
    private String company;

    //private Aeroplane aeroplane;
    //private List<Crew> crew;
}