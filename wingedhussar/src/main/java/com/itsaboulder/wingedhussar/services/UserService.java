package com.itsaboulder.wingedhussar.services;

import com.itsaboulder.wingedhussar.dtos.UserDto;
import com.itsaboulder.wingedhussar.entities.UserEntity;
import com.itsaboulder.wingedhussar.repositories.UserRepository;
import com.itsaboulder.wingedhussar.services.interfaces.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void register(UserDto user){
        if(checkIfUserExist(user.getEmail())){
            System.out.println("User already exists for this email");
            return;
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) !=null ? true : false;
    }

    @Override
    public void encodePassword(UserEntity userEntity, UserDto user) {
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
