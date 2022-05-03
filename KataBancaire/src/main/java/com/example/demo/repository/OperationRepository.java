package com.example.demo.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;
import com.example.demo.model.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Integer> {

    List<Operation> findByAccount(Account account );
    List<Operation> findByOperationId(Integer operationId); 
}
