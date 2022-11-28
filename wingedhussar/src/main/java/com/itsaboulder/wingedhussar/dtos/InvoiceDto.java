package com.itsaboulder.wingedhussar.dtos;

import lombok.Data;

@Data
public class InvoiceDto {
    private Long Id;
    private Long User;
    private Long Flight;
    private float FullAmount;
}
