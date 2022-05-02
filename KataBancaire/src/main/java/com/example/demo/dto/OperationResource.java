package com.example.demo.dto;

 import lombok.Getter;
 
import java.util.Date;

import com.example.demo.model.Operation;

@Getter
public class OperationResource   {

    private String operationType;
    private Double operationValue;
    private Date date;
    private Double balance;

    public OperationResource(Operation operation) {
        this.operationType = operation.getOperationType();
        this.operationValue = operation.getOperationValue();
        this.date = operation.getDate();
        this.balance = operation.getBalance();
    }

}
