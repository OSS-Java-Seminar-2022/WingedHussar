package com.itsaboulder.wingedhussar.repositories;

import com.itsaboulder.wingedhussar.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
}
