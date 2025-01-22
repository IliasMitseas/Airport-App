//package com.airport.air.model;
//import com.airport.air.service.FlightService;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.annotation.PostConstruct;
//import java.sql.*;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Slf4j
//
//public class ConnectionUtil {
//    public void setFlights (List<Flight> flightList) throws SQLException {
//
//        //Connect to my database
//        try(
//                Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/el-vel", "postgres", "mysecretpassword");
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM flight"); ){
//
//            // Extract data from result set
//            while (rs.next()) {
//                Flight flight = new Flight();
//                //set flight details
//                flight.setCompany(rs.getString("company"));
//                flight.setDestination(rs.getString("destination"));
//                flight.setCode(rs.getString("code"));
//                flight.setGate(rs.getString("gate"));
//                flight.setStatus(rs.getString("status"));
//                flight.setTime(LocalTime.parse(rs.getString("flight_time")));
//                String tempStatus = FlightService.statusMapper(flight);
//                flight.setStatus(tempStatus);
//
//                flightList.add(flight);
//            }
//
//        } catch(Exception e){
//            log.error("{}", e);
//        }
//    }
//}
