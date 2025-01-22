package com.airport.air.controller;
import java.sql.*;
import java.util.*;

import com.airport.air.repository.FlightRepository;
import com.airport.air.service.FlightService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.airport.air.model.Flight;

@Controller
@Slf4j
public class AirportController {

    @Autowired
    FlightService flightService;

    //Homepage
    @GetMapping()
    String getAllFlights(Model model) throws SQLException {
        log.info("Hello @@@@@@@@@@@@@@@");

        long start = System.currentTimeMillis();

        List<Flight> flightList = flightService.findAllFlights();

        //Set Status dynamically
//        flightService.mapStatusByTime(flightList);

        model.addAttribute("flights", flightList);

        long end = System.currentTimeMillis();

        log.info("time: {}", (end-start));

        return "home";
    }


//    @GetMapping("/flight/{flightId}")
//    public String showFlightDetails(@PathVariable int flightId, Model model) {
//        //Find if a flight exists by his code
//        Flight flight = flightService.findById(flightId);
//
//        if (flight != null) {
//            model.addAttribute("flight", flight);
//            return "flight-details";
//        } else {
//            // Handle flight not found scenario
//            return "flight-not-found";
//        }
//    }

    @GetMapping("/flight/{flightCode}")
    public String showFlightDetails(@PathVariable String flightCode, Model model) {
        //Find if a flight exists by his code
        Flight flight = flightService.findByCode(flightCode);

        if (flight != null) {
            model.addAttribute("flight", flight);
            return "flight-details";
        } else {
            // Handle flight not found scenario
            return "flight-not-found";
        }
    }

//    //Add a new flight page
//    @GetMapping("/add-flight")
//    public String showAddForm(Model model) {
//        model.addAttribute("flight", new Flight());
//        return "addflight";
//    }
//
//    //Handle a new flight request
//    @PostMapping("/add")
//        public String addSubmitHandler(@ModelAttribute FlightDto flightDto, Model model) throws SQLException {
//
//        //Try to find if a flight already exists
//        try {
//            //Create the flight I want to add
//            Flight addFlight = flightService.mapDtoToFlight(flightDto);
//            boolean currFlight = flightService.checkForDuplicates(addFlight);
//
//
//            if (currFlight){
//                model.addAttribute("flight", flightDto);
//                model.addAttribute("alreadyExists", "That flight already exists");
//                return "addflight";
//            }
//            // If flight does not exist I add the flight in my db
//            else {
//                crudRepository.add(addFlight);
//            }
//        } //here I handle the time error when I add a new flight
//        catch (DateTimeParseException timeException){
//            model.addAttribute("errorMessage", "Enter a valid time please");
//            model.addAttribute("flight", flightDto);
//            return "addflight";
//        }
//
//
//        /* Redirect to the flight details page
//           Read one */
//        return "redirect:/";
//    }
//
    //Read one - Details for each flight

//
//    //Delete a flight
//    @PostMapping("/delete-flight/{flightId}") //why PostMapping and no DeleteMapping?
//    public String deleteFlight(@PathVariable int flightId, Model model) {
//        crudRepository.deleteById(flightId);
//        return "redirect:/";
//    }
//
//
//
//    //Update a Flight
//    @GetMapping("/flight/update/{flightId}")
//    public String updateFlightForm(@PathVariable int flightId, Model model) {
//        Flight flight = flightService.findFlightById(flightId);
//            // change LocalTime to String
//            String timeString = flight.getFlight_time().toString();
//
//            // Create a new FlightDto
//            FlightDto flightDto = flightService.mapFlightToDto(flight, timeString);
//
//            model.addAttribute("flight", flightDto);
//
//            return "updateflight";
//    }
//
//
//
//
//    @PostMapping("/flight/update/{flightId}")
//    //Pws ginetai akrivws h sundesh metaxu flight kai updatedFlight?
//    public String updateFlight(@PathVariable int flightId, @ModelAttribute("flight") FlightDto  updatedFlight, Model model) {
//
//        try {
//
//            //I use a new Flight to update the existing flight
//            Flight flightToUpdate = flightService.mapDtoToFlight(updatedFlight);
//            crudRepository.updateById(flightToUpdate, flightId);
//            return "redirect:/";
//        }
//        catch (DateTimeParseException timeException) {
//            model.addAttribute("errorMessage", "Enter a valid time please");
//            return "updateflight";
//        }
//    }
}
