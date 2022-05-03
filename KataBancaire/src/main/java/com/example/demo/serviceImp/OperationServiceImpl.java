package com.example.demo.serviceImp;

import com.example.demo.dto.NewOperationRequest;
import com.example.demo.model.Account;
import com.example.demo.model.Operation;
import com.example.demo.repository.OperationRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.DoubleFunction;

@Service("operation_service")
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private AccountService accountService;

    private static final DoubleFunction<String> evaluateOperationType = operation -> operation > 0 ? "deposit" : "withdrawal";

    @Transactional
    public Operation registerOperation(NewOperationRequest newOperationRequest, Account account) {
        accountService.updateAccountPosition(account);
        Double operationAmount = newOperationRequest.getOperationAmount();
        Operation operation = new Operation(evaluateOperationType.apply(operationAmount), operationAmount, account);
        return operationRepository.save(operation);
    }

    public List<Operation> getAllOperationForAccount(Account account ) {
         return operationRepository.findByAccount(account );
    }
    
    public List<Operation> getAllOperation() {
         return (List<Operation>) operationRepository.findAll();
    }
    
    public Integer getOperationById(Integer operationId) {
        List<Operation> a= operationRepository.findByOperationId( operationId);
         Integer accountNumber=a.get(0).getAccount().getAccountNumber();
    	return accountNumber;
   } 
    
    
}
