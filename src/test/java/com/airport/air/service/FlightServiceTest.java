//package com.airport.air.service;
//
//import com.airport.air.model.Flight;
//import com.airport.air.model.Status;
//import org.junit.jupiter.api.Test;
//
//import java.time.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//
//
//class FlightServiceTest {
//
//    FlightService service = new FlightService();
//
//
//    @Test
//    void findFlightByCode() {
//
//
//
//        List<Flight> flightList = createFlightList(LocalTime.parse("22:30"), LocalTime.parse("23:30"));
//
//
//        Flight flight = service.findFlightByCode("23456");
//
//        assertNotNull(flight);
//
//        assertEquals("23456", flight.getCode());
//
//        assertEquals("B 29", flight.getGate());
//
//        assertEquals(LocalTime.parse("23:00"), flight.getTime());
//
//        Flight flight3 = service.findFlightByCode("111111");
//
//        assertNull(flight3);
//    }
//
//    @Test
//    void findFlightByCode_Null() {
//
//        FlightService service = new FlightService();
//
//        List<Flight> flightList = createFlightList(LocalTime.parse("22:30"), LocalTime.parse("23:30"));
//
//        Flight flight3 = service.findFlightByCode("111111");
//
//        assertNull(flight3);}
//
//
//    //Test the order of the list after sorting
//    @Test
//    void orderFlightsByArrivalDate() {
//        FlightService service = new FlightService();
//
//
//        List<Flight> flightList = createFlightList(LocalTime.parse("22:30"), LocalTime.parse("23:30"));
//
//        service.orderFlightsByArrivalDate(flightList);
//
//        assertEquals(flightList.get(0).getTime(), LocalTime.parse("22:30"));
//        assertEquals(flightList.get(1).getTime(), LocalTime.parse("23:30"));
//    }
//
//
//
//    //Test timeFilter
//    @Test
//    void timeFilter() {
//
//        FlightService service = new FlightService();
//
//        LocalTime a = LocalTime.now().plusHours(1);
//
//        List<Flight> flightList = createFlightList(LocalTime.now().minusHours(1), a);
//
//
//        service.filterByTime(flightList);
//
//        assertEquals(flightList.get(0).getTime(), a);
//        }
//
//
//    //Test statusMapper for GATE_OPEN
//    @Test
//    void statusMapper_Gate_Open() {
//        FlightService service = new FlightService();
//
//        List<Flight> flightList = createFlightList(LocalTime.now().plusMinutes(45), LocalTime.now().plusMinutes(45));
//
//        assertEquals(service.statusMapper(flightList.get(0)), Status.GATE_OPEN.name());
//    }
//
//
//    //Test statusMapper for BOARDING
//    @Test
//    void statusMapper_Boarding() {
//        FlightService service = new FlightService();
//
//        List<Flight> flightList = createFlightList(LocalTime.now().plusMinutes(25), LocalTime.now().plusMinutes(45));
//
//        assertEquals(service.statusMapper(flightList.get(0)), Status.BOARDING.name());
//    }
//
//
//
//    //Test statusMapper SCHEDULED
//    @Test
//    void statusMapper_Scheduled() {
//        FlightService service = new FlightService();
//
//        List<Flight> flightList = createFlightList(LocalTime.now().plusHours(2), LocalTime.now().plusMinutes(45));
//
//        assertEquals(service.statusMapper(flightList.get(0)), Status.SCHEDULED.name());
//    }
//
//    public List createFlightList(LocalTime a, LocalTime b){
//
//        List<Flight> flightList = new ArrayList<>();
//
//        Flight flight0 = new Flight();
//        flight0.setCompany("Aegean");
//        flight0.setTime(a);
//        flight0.setGate("A 29");
//        flight0.setCode("12345");
//        flight0.setDestination("Kalamata");
//        String tempStatus0 = service.statusMapper(flight0);
//        flight0.setStatus(tempStatus0);
//        flightList.add(flight0);
//
//        Flight flight1 = new Flight();
//        flight1.setCompany("Air Med");
//        flight1.setTime(b);
//        flight1.setGate("B 29");
//        flight1.setCode("23456");
//        flight1.setDestination("Sudan");
//        String tempStatus1 = service.statusMapper(flight1);
//        flight1.setStatus(tempStatus1);
//        flightList.add(flight1);
//
//        return flightList;
//
//    }
//}