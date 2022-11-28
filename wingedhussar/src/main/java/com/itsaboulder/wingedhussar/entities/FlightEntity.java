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
@Table(name = "flights")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    private String From;
    private String To;
    private Instant Time;
    private String Gate;
    private String Remarks;

    @OneToOne(mappedBy = "flight")
    private InvoiceEntity Invoice;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Passenger_Flight",
            joinColumns = { @JoinColumn(name = "Flight_id") },
            inverseJoinColumns = { @JoinColumn(name = "Passenger_id") }
    )
    Set<UserEntity> Passengers = new HashSet<>();
}
