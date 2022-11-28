package com.itsaboulder.wingedhussar.mappers;

import com.itsaboulder.wingedhussar.dtos.InvoiceDto;
import com.itsaboulder.wingedhussar.entities.FlightEntity;
import com.itsaboulder.wingedhussar.entities.InvoiceEntity;
import com.itsaboulder.wingedhussar.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {
    public InvoiceDto mapEntityToDto(InvoiceEntity invoiceEntity) {

        var invoiceDto = new InvoiceDto();
        invoiceDto.setId(invoiceEntity.getId());
        invoiceDto.setUser(invoiceEntity.getUser().getId());
        invoiceDto.setFlight(invoiceEntity.getFlight().getId());
        invoiceDto.setFullAmount(invoiceEntity.getFullAmount());

        return invoiceDto;
    }

    public InvoiceEntity mapDtoToEntity(InvoiceDto invoiceDto, FlightEntity flight, UserEntity user) {

        var invoiceEntity = new InvoiceEntity();
        invoiceEntity.setId(invoiceDto.getId());
        invoiceEntity.setUser(user);
        invoiceEntity.setFlight(flight);
        invoiceEntity.setFullAmount(invoiceEntity.getFullAmount());

        return invoiceEntity;
    }
}
