package com.itsaboulder.wingedhussar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "luggage")
public class LuggageEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    private float Weight;

    @OneToMany(mappedBy="Luggage")
    private Set<UserFlightsEntity> UserFlights;
}
