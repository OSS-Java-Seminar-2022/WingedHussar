package com.itsaboulder.wingedhussar.dtos;

import lombok.Data;

@Data
public class BookingDto {
    private String FlightClass;
    private String Seat;
    private float Price;
    private float Discount;
    private float Weight;
    private Long UserId;
    private Long FlightId;
    private Long LuggageId;
}
