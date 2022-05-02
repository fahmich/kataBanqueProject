package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
 public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "operation_id")
    private Integer operationId;
    
    @Column(name = "operation_type")
    private String operationType;
    
    @Column(name = "operation_value")
    private Double operationValue;
    @Column(name = "operation_date")
    private Date date;
    
    @Column(name = "balance")
    private Double balance;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "account_id")
    private Account account;

    public Operation(String operationType, Double operationValue, Account account) {
        this.operationType = operationType;
        this.operationValue = operationValue;
        this.account = account;
        this.balance = account.getAccountPosition();
        this.date = new Date();
    }

	public Operation() {
		super();
 	}

	public Integer getOperationId() {
		return operationId;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public Double getOperationValue() {
		return operationValue;
	}

	public void setOperationValue(Double operationValue) {
		this.operationValue = operationValue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
