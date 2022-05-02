package com.example.demo.serviceImp;

import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("account_service")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void updateAccountPosition(Account account) {
        accountRepository.save(account);
    }

    public Optional<Account> getAccount(int accountNumber) {
        return accountRepository.getAccountByAccountNumber(accountNumber);
    }

    @Override
    public Double getAccountPosition(Integer accountNumber) throws AccountNotFoundException {
        Double accountPosition = accountRepository.getPositionForAccountNumber(accountNumber);
        if(accountPosition == null) throw new AccountNotFoundException(String.valueOf(accountNumber));
        return accountPosition;
    }
}
