package com.itsaboulder.wingedhussar.dtos;

import lombok.Data;

@Data
public class UserDto {
    private Long Id;
    private String FirstName;
    private String LastName;
    private String Role;
}
