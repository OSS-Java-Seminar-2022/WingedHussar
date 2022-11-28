package com.itsaboulder.wingedhussar.mappers;

import com.itsaboulder.wingedhussar.dtos.FlightDto;
import com.itsaboulder.wingedhussar.entities.FlightEntity;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    public FlightDto mapEntityToDto(FlightEntity flightEntity) {

        var flightDto = new FlightDto();
        flightDto.setId(flightEntity.getId());
        flightDto.setFrom(flightEntity.getFrom());
        flightDto.setTo(flightEntity.getTo());
        flightDto.setGate(flightEntity.getGate());
        flightDto.setTime(flightEntity.getTime());
        flightDto.setRemarks(flightEntity.getRemarks());

        return flightDto;
    }

    public FlightEntity mapDtoToEntity(FlightDto flightDto) {

        var flightEntity = new FlightEntity();
        flightEntity.setId(flightDto.getId());
        flightEntity.setTo(flightDto.getTo());
        flightEntity.setFrom(flightDto.getFrom());
        flightEntity.setTime(flightDto.getTime());
        flightEntity.setGate(flightDto.getGate());
        flightEntity.setRemarks(flightDto.getRemarks());

        return flightEntity;
    }
}
