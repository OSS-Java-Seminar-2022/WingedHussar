package com.itsaboulder.wingedhussar.services.interfaces;

import com.itsaboulder.wingedhussar.dtos.FlightDto;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface IFlightService {
    List<FlightDto> getFlights(int adults, String origin, String destination, String departureDate) throws IOException, InterruptedException, JSONException;
}
