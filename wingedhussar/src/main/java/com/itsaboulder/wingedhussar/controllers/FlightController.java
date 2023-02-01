package com.itsaboulder.wingedhussar.controllers;

import com.itsaboulder.wingedhussar.services.FlightService;
import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class FlightController {

    private FlightService flightService;

    @GetMapping("/flights")
    public String getFlights(Model model) throws IOException, InterruptedException, JSONException {
        model.addAttribute("flightList" , flightService.getFlights(1,"MAD","FCO","2023-01-30"));
        return "flights";
    }
}
