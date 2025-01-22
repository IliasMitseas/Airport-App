package com.airport.air.util;

import java.util.Comparator;

import com.airport.air.model.Flight;

public class SortByTime implements Comparator<Flight> {

    @Override
    public int compare(Flight a, Flight b){
        return a.getFlight_time().compareTo(b.getFlight_time());
    }

}
