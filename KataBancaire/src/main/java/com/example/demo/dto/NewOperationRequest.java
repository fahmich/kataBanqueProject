package com.example.demo.dto;

import lombok.*;
 
@Getter
@ToString
@EqualsAndHashCode
 public final class NewOperationRequest {
   
    private Integer accountNumber; 
    private Double operationAmount;

    public NewOperationRequest(Integer accountNumber, Double operationAmount) {
        this.accountNumber = accountNumber;
        this.operationAmount = operationAmount;
    }
    

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getOperationAmount() {
		return operationAmount;
	}

	public void setOperationAmount(Double operationAmount) {
		this.operationAmount = operationAmount;
	}


	public NewOperationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
