package com.airport.air.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode
@Setter
@Getter
@Entity
@Table(name = "aeroplane")
public class Aeroplane {

    @Column
    @Id
    private int aeroplaneid;

    @Column
    private String type;

    @Column
    private int capacity;
}
