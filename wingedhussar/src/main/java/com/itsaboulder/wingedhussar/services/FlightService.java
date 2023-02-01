package com.itsaboulder.wingedhussar.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsaboulder.wingedhussar.dtos.FlightDto;
import com.itsaboulder.wingedhussar.entities.FlightEntity;
import com.itsaboulder.wingedhussar.services.interfaces.IFlightService;
import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FlightService implements IFlightService {

    ObjectMapper objectMapper;

    @Override
    public List<FlightDto> getFlights(int adults, String from, String to, String departureDate) throws IOException, InterruptedException, JSONException {
        var flights = new ArrayList<FlightDto>();
        var url = "https://app.goflightlabs.com/search-all-flights?access_key=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI0IiwianRpIjoiNmJmNjk1ZTdlNzNkMDE3M2MwODRhNDlmYTczNWNjYmI1YWM3MTVlZWViNjRiOTg2ZTY5ODcxN2Y0MmMyYzc2NDcxN2RlMWMxNTRhN2Y0NGEiLCJpYXQiOjE2NzE0ODIyOTUsIm5iZiI6MTY3MTQ4MjI5NSwiZXhwIjoxNzAzMDE4Mjk1LCJzdWIiOiIxOTMwNSIsInNjb3BlcyI6W119.gAK9LthLAlO_1Gt5hbLKFb4jkXCCRFBS3l1oX_E2YdcnwicIGTnf0vDxdU_C3uthHnMONcq2ElDusl0fvxtRAA&adults="+adults+"&origin="+from+"&destination="+to+"&departureDate="+departureDate;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        var json = response.body();
        var obj = new JSONObject(json);
        var data = obj.getJSONObject("data");
        var results = data.getJSONArray("results");
        for(var i = 0; i<results.length(); i++){
            var legs = results.getJSONObject(i);
            var legArray = legs.getJSONArray("legs");
            var leg = legArray.getJSONObject(0);
            var origin = leg.getJSONObject("origin");
            var destination = leg.getJSONObject("destination");
            var carrier = leg.getJSONObject("carriers");
            var marketingCarrierArray = carrier.getJSONArray("marketing");
            var marketingCarrier = marketingCarrierArray.getJSONObject(0);
            var flight = new FlightDto();
            flight.setFrom(origin.getString("name"));
            flight.setTo(destination.getString("name"));
            flight.setDepartureDateTime(LocalDateTime.parse((leg.getString("departure"))));
            flight.setCarrier(marketingCarrier.getString("name"));
            flights.add(flight);
        }
        return flights;
    }
}
