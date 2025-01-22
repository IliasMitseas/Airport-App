package com.airport.air.repository;

import com.airport.air.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {


    @Query("select f from Flight f where f.id=id")
    Flight findById(@Param("id") int id);

    Flight findByCode(String code);

}
