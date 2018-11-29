/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citycorp.controller;

import com.citycorp.model.Client;
import com.citycorp.model.Loan;
import com.citycorp.model.RepaymentSchedule;
import com.citycorp.payload.*;

import com.citycorp.repository.*;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api")
public class PaymentController {
    
    @Autowired
    private PaymentRepository pRepository;
    @Autowired
    
    private LoanRepository lRepository;
    
    @Autowired
    private ClientRepository cRepository;
    
      @Autowired
    private RepaymentScheduleRepository rRepository;
    
    
     @PostMapping("/receipt/check")
    public ApiResponse chekReceiptNumber(@Valid @RequestBody PaymentRequest paymentRequest){ 
        
 if (pRepository.existsByReceiptNumber(paymentRequest.getReceiptNumber())){
      return new ApiResponse(false, "Receipt Number Exists");
 }else if (!pRepository.existsByReceiptNumber(paymentRequest.getReceiptNumber())){
     
  return new ApiResponse(true, "Receipt Number Available");
        
    }
  return new ApiResponse(true, "Checkeed Successfully");
   
}
     @PostMapping("/client/get")
     public Optional<Client>  getClient (@Valid @RequestBody LoanRequest lRequest) {
    	 //System.out.println(lRepository.findClientIdById(lRequest.getId()));
    	 
    	Optional<Client> c = cRepository.findById(lRepository.findClientIdById(lRequest.getId()));  	 
    	 return c;
    	
     }
     @PostMapping("/details/get")
     public Optional<Client>  getDetails (@Valid @RequestBody ClientRequest cRequest) {
    	 //System.out.println(lRepository.findClientIdById(lRequest.getId()));
    	 
    	Optional<Client> c = cRepository.findById(cRequest.getClientId());  	 
    	 return c;
    	
     }
     
     @PostMapping("/payment/get")
     public Optional<RepaymentSchedule>  getPaymentSchedule (@Valid @RequestBody RepaymentScheduleRequest rRequest) {
    	 //System.out.println(lRepository.findClientIdById(lRequest.getId()));
    	 
    	Optional<RepaymentSchedule> p = rRepository.findByLoanId(rRequest.getLoanId());  	 
    	 return p;
    	
     }
}
