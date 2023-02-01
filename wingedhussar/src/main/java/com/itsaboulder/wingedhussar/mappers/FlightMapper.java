package com.itsaboulder.wingedhussar.mappers;

import com.itsaboulder.wingedhussar.dtos.FlightDto;
import com.itsaboulder.wingedhussar.entities.FlightEntity;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    public FlightDto mapEntityToDto(FlightEntity flightEntity) {

        var flightDto = new FlightDto();
        flightDto.setFrom(flightEntity.getFrom());
        flightDto.setTo(flightEntity.getTo());
        flightDto.setGate(flightEntity.getGate());
        flightDto.setDepartureDateTime(flightEntity.getDepartureDateTime());
        flightDto.setCarrier(flightEntity.getCarrier());
        flightDto.setRemarks(flightEntity.getRemarks());

        return flightDto;
    }

    public FlightEntity mapDtoToEntity(FlightDto flightDto) {

        var flightEntity = new FlightEntity();
        flightEntity.setTo(flightDto.getTo());
        flightEntity.setFrom(flightDto.getFrom());
        flightEntity.setDepartureDateTime(flightDto.getDepartureDateTime());
        flightEntity.setCarrier(flightDto.getCarrier());
        flightEntity.setGate(flightDto.getGate());
        flightEntity.setRemarks(flightDto.getRemarks());

        return flightEntity;
    }
}
