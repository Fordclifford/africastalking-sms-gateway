package com.citycorp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "m_payment_detail")
public class Payment {
	
	@Column(name = "id")
    @Id
	 private Long id;


	 
	 @Column(name = "payment_type_id")
	 private Long paymentTypeId;
	 	 
	 @Column(name = "account_number")
	private String  accountNumber;
	 
	 @Column(name = "check_number")
	 private String checkNumber;
	 
	 @Column(name = "receipt_number")
	 private String receiptNumber;
	 
	 @Column(name = "bank_number")
	 private String bankNumber;
	 
	 @Column(name = "routing_code")
	 private String routingCode;

    public Payment(Long paymentTypeId, String accountNumber, String checkNumber, String receiptNumber, String bankNumber, String routingCode) {
        this.paymentTypeId = paymentTypeId;
        this.accountNumber = accountNumber;
        this.checkNumber = checkNumber;
        this.receiptNumber = receiptNumber;
        this.bankNumber = bankNumber;
        this.routingCode = routingCode;
    }

    public Payment() {
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public String getRoutingCode() {
        return routingCode;
    }

    public void setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }
         
         
         
         

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
      }
