package com.itsaboulder.wingedhussar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user-flights")
public class UserFlightsEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    private String FlightClass;
    private String Seat;
    private float Price;
    private float Discount;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity User;

    @ManyToOne
    @JoinColumn(name="flight_id", nullable=false)
    private FlightEntity Flight;

    @ManyToOne
    @JoinColumn(name="luggage_id", nullable=false)
    private LuggageEntity Luggage;
}
