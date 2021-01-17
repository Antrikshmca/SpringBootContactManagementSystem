package com.antriksh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antriksh.app.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
