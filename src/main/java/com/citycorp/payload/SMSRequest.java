/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citycorp.payload;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
public class SMSRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
   
    private String[] phone;
    
       
    
    private String message;

    public Long getId() {
        return id;
    }

    public String[] getPhone() {
        return phone;
    }

   

    public String getMessage() {
        return message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }

    

    public void setMessage(String message) {
        this.message = message;
    }
    
}
