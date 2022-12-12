package com.itsaboulder.wingedhussar.repositories;

import com.itsaboulder.wingedhussar.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
