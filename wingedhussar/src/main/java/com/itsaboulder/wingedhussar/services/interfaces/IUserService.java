package com.itsaboulder.wingedhussar.services.interfaces;

import com.itsaboulder.wingedhussar.dtos.UserDto;
import com.itsaboulder.wingedhussar.entities.UserEntity;

public interface IUserService {
    void register(UserDto user);
    boolean checkIfUserExist(String email);
    void encodePassword( UserEntity userEntity, UserDto user);
    void login(UserDto user);
}
