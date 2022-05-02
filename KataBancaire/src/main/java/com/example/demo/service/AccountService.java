package com.example.demo.service;
 
import java.util.Optional;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.model.Account;

public interface AccountService {

    void updateAccountPosition(Account account);

    Optional<Account> getAccount(int accountNumber);

    Double getAccountPosition(Integer accountNumber) throws AccountNotFoundException  ;
}
