package com.itsaboulder.wingedhussar.dtos;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class FlightDto {
    private String From;
    private String To;
    private LocalDateTime DepartureDateTime;
    private String Gate;
    private String Remarks;
    private String Carrier;
}
