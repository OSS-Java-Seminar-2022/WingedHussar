package com.itsaboulder.wingedhussar.dataloader;

import com.itsaboulder.wingedhussar.entities.FlightEntity;
import com.itsaboulder.wingedhussar.entities.InvoiceEntity;
import com.itsaboulder.wingedhussar.entities.UserEntity;
import com.itsaboulder.wingedhussar.repositories.FlightRepository;
import com.itsaboulder.wingedhussar.repositories.InvoiceRepository;
import com.itsaboulder.wingedhussar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void run(String... args) throws Exception{
        cleanDatabase();
        var user1 = createUser1();
        var user2 = createUser2();
        var flight = createFlight(user2);
        var invoice = createInvoice(user2, flight);
    }

    private void cleanDatabase(){
        userRepository.deleteAll();
        flightRepository.deleteAll();
        invoiceRepository.deleteAll();
    }

    private UserEntity createUser1(){
        var user = new UserEntity(null, "Ante", "Antic", "admin", null, null);
        return  user;
    }

    private UserEntity createUser2(){
        var user = new UserEntity(null, "Mate", "Matic", "passenger", null, null);
        return  user;
    }

    private FlightEntity createFlight(UserEntity user){
        var flight = new FlightEntity(null, "St-Cro", "Am-Ned", Instant.parse("2022-10-29T05:00:00.00Z"), "1A", "Early flight", null, new HashSet<>(Arrays.asList(user)));
        return  flight;
    }

    private InvoiceEntity createInvoice(UserEntity user, FlightEntity flight){
        var invoice = new InvoiceEntity(null, user, flight, 850f);
        return  invoice;
    }
}
