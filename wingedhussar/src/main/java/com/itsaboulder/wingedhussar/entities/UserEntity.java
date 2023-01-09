package com.itsaboulder.wingedhussar.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    private String FirstName;
    private String LastName;
    private String Username;
    private String Email;
    private String Password;
    private String Role;

    @OneToMany(mappedBy="User")
    private Set<InvoiceEntity> Invoices;

    @OneToMany(mappedBy="User")
    private Set<UserFlightsEntity> UserFlights;
}