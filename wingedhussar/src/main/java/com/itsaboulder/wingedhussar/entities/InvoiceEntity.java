package com.itsaboulder.wingedhussar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoices")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    private float FullAmount;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity User;

    @ManyToOne
    @JoinColumn(name="flight_id", nullable=false)
    private FlightEntity Flight;
}
