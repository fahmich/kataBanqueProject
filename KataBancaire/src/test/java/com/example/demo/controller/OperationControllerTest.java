package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.dto.NewOperationRequest;
import com.example.demo.model.Account;
import com.example.demo.model.Client;
import com.example.demo.model.Operation;
import com.example.demo.service.AccountService;
import com.example.demo.service.OperationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OperationController.class)
class OperationControllerTest {
	@Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;
 
	  @MockBean
	    private OperationService operationService;

	  @MockBean
	    private AccountService accountService;

	  @Captor
	  private ArgumentCaptor<NewOperationRequest> newOperationRequest;

	@Test
	void testExecuteOperationsDeposit() {
//		NewOperationRequest newOperationRequest = new NewOperationRequest();
//		newOperationRequest.setAccountNumber( 52810848 );
//		newOperationRequest.setOperationAmount(500.0);
// 
//	    when(operationService.registerOperation(
//	    	 createNewOperationRequest(52810848,500.0),
//	    	 createAccount(52810848, 1.0, new Client() ))
//	    		.thenReturn(new Operation ("deposit", 500.0, new Account() ))
//	    		  ;
//
//	    this.mockMvc
//	      .perform(post("/operations/us12")
//	        .contentType(MediaType.APPLICATION_JSON)
//	        .content(objectMapper.writeValueAsString(newOperationRequest)))
//	      .andExpect(content().contentType("application/json"))
//	      .andExpect(jsonPath("$.operationType", is("deposit")))
//	      .andExpect(jsonPath("$.operationValue", is(500.0))) ;
//	  
//
//	    assertThat(newOperationRequest.getAccountNumber(), is("deposit"));
//	    assertThat(newOperationRequest.getOperationAmount() , is(500.0));
 	}

	@Test
	void testGetOperationInfo() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllOperationForAClient() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAccountPosition() {
		fail("Not yet implemented");
	}
	
	  private NewOperationRequest createNewOperationRequest(Integer accountNumber,
			  Double operationAmount) {
		      NewOperationRequest newOperationRequest = new NewOperationRequest();
			  newOperationRequest.setAccountNumber( accountNumber );
			  newOperationRequest.setOperationAmount(operationAmount);
		     
		    return newOperationRequest;
		  }
	  private Account createAccount(Integer accountNumber, Double accountPosition, 
			  Client client) {
		      Account account = new Account();
		      account.setAccountId(1);
		      account.setAccountNumber(accountNumber);
		      account.setAccountPosition( accountPosition);
		      account.setClient(new Client() );
 
		    return account;
		  }

}
