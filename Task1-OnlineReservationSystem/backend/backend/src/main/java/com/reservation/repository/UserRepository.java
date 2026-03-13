package com.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

}