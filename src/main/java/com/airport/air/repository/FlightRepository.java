package com.airport.air.repository;

import com.airport.air.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {

    //Custom Query to find a flight by id. I could have used Flight findById(int id) due to hibernate;
    @Query("select f from Flight f where f.id = :id")
    Flight findById(@Param("id") int id);

    @Modifying //Not a select query. I use it for delete and update
    @Transactional //
    void deleteById(int id);

}
