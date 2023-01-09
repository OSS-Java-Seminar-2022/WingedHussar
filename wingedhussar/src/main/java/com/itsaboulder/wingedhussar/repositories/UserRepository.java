package com.itsaboulder.wingedhussar.repositories;

import com.itsaboulder.wingedhussar.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT x FROM UserEntity x WHERE x.Email = :email")
    public UserEntity findByEmail(@Param("email") String email);

}
