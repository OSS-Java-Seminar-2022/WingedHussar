package com.itsaboulder.wingedhussar.mappers;

import com.itsaboulder.wingedhussar.dtos.UserDto;
import com.itsaboulder.wingedhussar.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto mapEntityToDto(UserEntity userEntity) {

        var userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setRole(userEntity.getRole());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());

        return userDto;
    }

    public UserEntity mapDtoToEntity(UserDto userDto) {

        var userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setRole(userDto.getRole());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());

        return userEntity;
    }
}
