package com.itsaboulder.wingedhussar.dtos;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String username;
    private String email;
    private String password;
}
