package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.NewOperationRequest;
import com.example.demo.model.Account;
import com.example.demo.model.Operation;

public interface OperationService {

    Operation registerOperation(NewOperationRequest newOperationRequest, Account account);

    List<Operation> getAllOperationForAccount(Account account );
    
     public List<Operation> getAllOperation() ;
     public Integer getOperationById(Integer operationId);
}
