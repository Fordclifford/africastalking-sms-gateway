/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citycorp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name= "m_loan_repayment_schedule")
public class RepaymentSchedule {
    
    @Column(name = "id")
    @Id
    private Long id;
    
    @Column(name = "loan_id")
    private Long loanId;
    
    @Column(name = "principal_amount")
    private Double principalAmount;

    public RepaymentSchedule(Long id, Long loanId, Double principalAmount) {
        this.id = id;
        this.loanId = loanId;
        this.principalAmount = principalAmount;
    }

    public RepaymentSchedule() {
    }
    
    

    public Long getId() {
        return id;
    }

    public Long getLoanId() {
        return loanId;
    }

    public Double getPrincipalAmount() {
        return principalAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public void setPrincipalAmount(Double principalAmount) {
        this.principalAmount = principalAmount;
    }
    
    
    
    
    
}
