package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
 public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "account_id")
    private Integer accountId;
    
    @Column(unique = true, nullable = false)
    private Integer accountNumber;
    
    @Column(nullable = false)
    private Double accountPosition;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    
    public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAccountPosition() {
		return accountPosition;
	}
	public void setAccountPosition(Double accountPosition) {
		this.accountPosition = accountPosition;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}


	public Account(Integer accountNumber, Double accountPosition, Client client) {
        this.accountNumber = accountNumber;
        this.accountPosition = accountPosition;
        this.client = client;
    }
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}

