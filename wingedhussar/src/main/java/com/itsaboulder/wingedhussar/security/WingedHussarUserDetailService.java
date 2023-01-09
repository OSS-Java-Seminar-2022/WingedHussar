package com.itsaboulder.wingedhussar.security;

import com.itsaboulder.wingedhussar.entities.UserEntity;
import com.itsaboulder.wingedhussar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class WingedHussarUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if(user != null) {
            return new WingedHussarUserDetails(user);
        }
        throw new UsernameNotFoundException("User not found with given email" + email);
    }
}
