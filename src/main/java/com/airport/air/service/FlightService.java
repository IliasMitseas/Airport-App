package com.airport.air.service;

import com.airport.air.model.Flight;
import com.airport.air.model.Status;
import com.airport.air.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.MINUTES;

@Slf4j


@Service
public class FlightService {


    @Autowired
    FlightRepository flightRepository;

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public Flight findById(int id){
        return flightRepository.findById(id);
    }


    public void deleteById(int id) {
        flightRepository.deleteById(id);
    }

//    public void orderFlightsByArrivalDate(List<Flight> flightList) {
//        Collections.sort(flightList, new SortByTime());
//    }
//
//

//
//
//    /* Method to check if time of a flight have passed
//    When I iterate through a list and I make changes on the same time(change an element's value for example) I need to use an iterator*/
//    public void filterByTime(List<Flight> flightList) {
//        Iterator<Flight> it = flightList.iterator();
//        while (it.hasNext()) {
//            Flight flight = it.next();
//            int z = (int) LocalTime.now().until(flight.getFlight_time(), MINUTES);
//            if (z < 0)
//                it.remove();
//        }
//    }
//

    //Method to iterate the whole list and change status dynamically
    public void mapStatusByTime(List<Flight> flightList) {
        Iterator<Flight> it = flightList.iterator();
        while (it.hasNext()) {
            Flight flight = it.next();
            int z = (int) LocalTime.now().until(flight.getFlight_time(), MINUTES);
            if (z < 30)
                flight.setStatus(Status.BOARDING.name());
            else if (z < 60)
                flight.setStatus(Status.GATE_OPEN.name());
            else flight.setStatus(Status.SCHEDULED.name());
        }
    }
//
//    //Method to check for duplicates
//    public boolean checkForDuplicates(Flight addFlight) throws SQLException {
//        int count = jdbcRepository.countByFlight(addFlight);
//
//        return count == 1;
//        }
//
//
//    public Flight mapDtoToFlight(FlightDto flightDto) {
//        Flight addFlight = new Flight();
//        addFlight.setCode(flightDto.getCode());
//        addFlight.setCompany(flightDto.getCompany());
//        addFlight.setDestination(flightDto.getDestination());
//        addFlight.setFlight_time(LocalTime.parse(flightDto.getFlight_time()));
//        addFlight.setGate(flightDto.getGate());
//        String tempStatusAdd = statusMapper(addFlight);
//        addFlight.setStatus(tempStatusAdd);
//        return addFlight;
//    }
//
//    public FlightDto mapFlightToDto(Flight flight, String timeString){
//        FlightDto flightDto = new FlightDto();
//        flightDto.setCompany(flight.getCompany());
//        flightDto.setCode(flight.getCode());
//        flightDto.setDestination(flight.getDestination());
//        flightDto.setId(flight.getId());
//
//        //time as a string
//        flightDto.setFlight_time(timeString);
//        flightDto.setGate(flight.getGate());
//        flightDto.setStatus(flight.getStatus());
//        return flightDto;
//    }


}