package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountPositionResponse;
import com.example.demo.dto.NewOperationRequest;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.InsufficientFundException;
import com.example.demo.model.Account;
import com.example.demo.model.Operation;
import com.example.demo.service.AccountService;
import com.example.demo.service.OperationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/operations/")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private AccountService accountService;
    
     public static final Logger LOGGER = Logger.getLogger(OperationController.class.getName());
    
    @PostMapping(path = "/us12", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Operation> executeOperationsDepositAndWithdrawal(
    		@Validated @RequestBody NewOperationRequest newOperationRequest
                                           ) throws AccountNotFoundException, InsufficientFundException {

        LOGGER.info("executeOperation() newOperationRequest:"+ newOperationRequest+", for Client: "+ + newOperationRequest.getAccountNumber());

        Optional<Account> optionalAccount = accountService.getAccount(newOperationRequest.getAccountNumber());
 
        if (! optionalAccount.isPresent()) {
            throw new AccountNotFoundException(String.valueOf(newOperationRequest.getAccountNumber()));
        }
        Account account = optionalAccount.get();
 
        Double newAccountPosition = account.getAccountPosition() + newOperationRequest.getOperationAmount();

        if (newAccountPosition < 0) {
           throw new InsufficientFundException(String.valueOf(newOperationRequest.getAccountNumber()));
        }

        account.setAccountPosition(newAccountPosition);
        LOGGER.info("Account  position updated " + account.getAccountNumber());
        Operation operation = operationService.registerOperation(newOperationRequest, account);
        
        LOGGER.info("New Operation registered for account " + account.getAccountNumber());

        return new ResponseEntity<>(operation, HttpStatus.CREATED);
    }

    @GetMapping("/ops")
    public ResponseEntity<List<Operation>> getOperationInfo(
    		@RequestParam(value = "accountNumber", required = true) int accountNumber 
                                                     ) throws AccountNotFoundException {  

        Optional<Account> optionalAccount = accountService.getAccount(accountNumber);
        if (! optionalAccount.isPresent()) {
            throw new AccountNotFoundException(String.valueOf(accountNumber));
        }
        Account account = optionalAccount.get();
 
       List<Operation> operationHistory = operationService.getAllOperation();
 
         return ResponseEntity.status(HttpStatus.OK).body(operationHistory);
    }

    @GetMapping
   public ResponseEntity<List<Operation>> getAllOperationForAClient(
                                                     @RequestParam(value = "accountNumber", required = true) int accountNumber,
                                                     @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                     @RequestParam(value = "size", required = false, defaultValue = "10") int size
                                                    ) throws AccountNotFoundException {
 
    LOGGER.info("getAllOperationForAClient() accountNumber:  "+ accountNumber);
 
        Optional<Account> optionalAccount = accountService.getAccount(accountNumber);
        if (! optionalAccount.isPresent()) {
            throw new AccountNotFoundException(String.valueOf(accountNumber));
        }
        Account account = optionalAccount.get();
 
       List<Operation> operationHistory = operationService.getAllOperationForAccount(account, page, size);
 
         return ResponseEntity.status(HttpStatus.OK).body(operationHistory);
    }

    @GetMapping(path = "/{accountNumber}/position", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAccountPosition(@PathVariable("accountNumber") final Integer accountNumber) throws AccountNotFoundException {

       LOGGER.info("getAccountPosition() accountNumber: "+ accountNumber);

        Double position = accountService.getAccountPosition(accountNumber);
        
        LOGGER.info("get position: "+ position);
     
        AccountPositionResponse accountPositionResponse = new AccountPositionResponse(position);

        return ResponseEntity.status(HttpStatus.OK).body(accountPositionResponse);
    }

}
