package com.itsaboulder.wingedhussar.dtos;

import lombok.Data;

import java.time.Instant;

@Data
public class FlightDto {
    private Long Id;
    private String From;
    private String To;
    private Instant Time;
    private String Gate;
    private String Remarks;
}
