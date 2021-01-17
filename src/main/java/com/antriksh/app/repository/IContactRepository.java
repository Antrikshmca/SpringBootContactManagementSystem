package com.antriksh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antriksh.app.model.Contact;

public interface IContactRepository extends JpaRepository<Contact, Integer> {

}
