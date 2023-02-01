package com.itsaboulder.wingedhussar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flights")
public class FlightEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    private String From;
    private String To;
    private LocalDateTime DepartureDateTime;
    private String Gate;
    private String Remarks;
    private String Carrier;

    @OneToMany(mappedBy="Flight")
    private Set<InvoiceEntity> Invoice;

    @OneToMany(mappedBy="Flight")
    private Set<UserFlightsEntity> UserFlights;
}
