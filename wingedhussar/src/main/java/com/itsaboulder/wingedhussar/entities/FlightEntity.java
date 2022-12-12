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

    @OneToMany(mappedBy="Flight")
    private Set<InvoiceEntity> Invoice;

    @OneToMany(mappedBy="Flight")
    private Set<UserFlightsEntity> UserFlights;
}
