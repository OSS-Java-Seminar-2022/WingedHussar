package com.itsaboulder.wingedhussar.mappers;

import com.itsaboulder.wingedhussar.dtos.BookingDto;
import com.itsaboulder.wingedhussar.entities.LuggageEntity;
import com.itsaboulder.wingedhussar.entities.UserFlightsEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class BookingMapper {
    public BookingDto mapEntityToDto(LuggageEntity luggageEntity, UserFlightsEntity userFlightsEntity) {

        var bookingDto = new BookingDto();
        bookingDto.setDiscount(userFlightsEntity.getDiscount());
        bookingDto.setPrice(userFlightsEntity.getPrice());
        bookingDto.setSeat(userFlightsEntity.getSeat());
        bookingDto.setWeight(luggageEntity.getWeight());

        return bookingDto;
    }

    public Map<UserFlightsEntity, LuggageEntity> mapDtoToEntity(BookingDto bookingDto) {

        var luggageEntity = new LuggageEntity();
        var userFlightsEntity = new UserFlightsEntity();
        userFlightsEntity.setDiscount(bookingDto.getDiscount());
        userFlightsEntity.setPrice(bookingDto.getPrice());
        userFlightsEntity.setSeat(bookingDto.getSeat());
        luggageEntity.setWeight(bookingDto.getWeight());
        Map<UserFlightsEntity, LuggageEntity> toReturn = new HashMap<>();
        toReturn.put(userFlightsEntity, luggageEntity);

        return toReturn;
    }
}
