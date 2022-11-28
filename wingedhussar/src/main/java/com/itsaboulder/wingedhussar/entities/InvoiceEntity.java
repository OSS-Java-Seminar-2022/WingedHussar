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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity User;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private FlightEntity Flight;

    private float FullAmount;
}
