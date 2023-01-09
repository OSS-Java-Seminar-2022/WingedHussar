package com.itsaboulder.wingedhussar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.itsaboulder.wingedhussar.entities"})
public class WingedhussarApplication {

	public static void main(String[] args) {
		SpringApplication.run(WingedhussarApplication.class, args);
	}

}
