/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citycorp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table()
    public class EmailService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
       
    @Size(max = 40)
    private String email;

    
    @Size(max = 100)
    private String message;
    
     @Size(max = 100)
    private String attachment;
     
   private String fromEmail;
   private String toEmail;
   private String subject;

    public EmailService() {
    }

    public EmailService(String message, String attachment, String fromEmail, String toEmail, String subject) {
        this.message = message;
        this.attachment = attachment;
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.subject = subject;
    }
   
   
   
   

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public String getAttachment() {
        return attachment;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
   
   
   
    
    
    
    
}
