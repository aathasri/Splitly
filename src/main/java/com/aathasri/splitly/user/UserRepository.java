package com.aathasri.splitly.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT s FROM User s WHERE s.email = ?!")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT s FROM User s WHERE s.username = ?!")
    Optional<User> findUserByUsername(String email);


}
