package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findBySurnameOrEmail(String usernameOrEmail, String usernameOrEmail1);

}
