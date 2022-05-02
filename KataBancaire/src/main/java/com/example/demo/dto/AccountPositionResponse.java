package com.example.demo.dto;

import lombok.*;

@Data 
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountPositionResponse {
    private Double accountPosition;

    
    public Double getAccountPosition() {
		return accountPosition;
	}


	public void setAccountPosition(Double accountPosition) {
		this.accountPosition = accountPosition;
	}


	@Override
	public String toString() {
		return "AccountPositionResponse [accountPosition=" + accountPosition + "]";
	}
 
	public AccountPositionResponse(Double accountPosition) {
        this.accountPosition = accountPosition;
    }
}
