/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citycorp.controller;
import com.africastalking.*;
import com.africastalking.sms.Recipient;
import com.citycorp.model.EmailService;
import com.citycorp.model.SMS;
import com.citycorp.model.SMSCredentials;
import com.citycorp.payload.ApiResponse;
import com.citycorp.payload.EmailRequest;
import com.citycorp.payload.SMSRequest;
import com.citycorp.repository.EmailRepository;
import com.citycorp.repository.SMSCredentialsRespository;
import com.citycorp.repository.SMSRepository;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;




/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api")
public class SMSController  {
    
    @Autowired
    private SMSRepository smsRepository;
    
     @Autowired
    public JavaMailSender emailSender;
     
     @Autowired
     private static SMSCredentialsRespository smsCred;
     
     //static SMSCredentials cred = smsCred.findById(1);
      
     
          @Autowired
    private EmailRepository emailRepository;
 
    
    private static final int HTTP_PORT = 9090;
   // private final static  String USERNAME = cred.getUsername();
    //private final static String API_KEY = cred.getApiKey();
    
     private static void log(String message) {
        System.out.println(message);
    }
     
    
    private static void setupAfricastalking() throws IOException {
         InetAddress host = Inet4Address.getLocalHost();
        log("\n");
        log(String.format("HTTP Server: %s:%d", host.getHostAddress(), HTTP_PORT));
        log("\n");
        
        log("\n");
        log("API Key: "+ smsCred.getUserName());
        log("\n");



        AfricasTalking.initialize("krufed", "dca4182bf9bde4c0b0b9952259089c3cb10f2334f0099ac61c1730180f55f190");
        AfricasTalking.setLogger(new Logger(){
            @Override
            public void log(String message, Object... args) {
                System.out.println(message);
            }
        });
           }
    
    
    @PostMapping("/sms/send")
    public List<SMSCredentials> sendSMS( @Valid @RequestBody SMSRequest smsRequest) throws IOException{
    	 log("\n");
       //  log("API Key: "+ cred.getUsername());
         log("\n");
        setupAfricastalking();
        String p= Arrays.toString(smsRequest.getPhone());
        SMS text = new SMS( p,smsRequest.getMessage());
         SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
         
         
      
        	 sms.send(smsRequest.getMessage(),null, smsRequest.getPhone(),false);
              
                
        smsRepository.save(text);     
        

  return smsCred.getApiKeyandUsername();
        
    }
    
    
    @PostMapping("/email/send")
    public ApiResponse sendEmail( @Valid @RequestBody EmailRequest emailRequest) throws  javax.mail.MessagingException{
        javax.mail.internet.MimeMessage message = emailSender.createMimeMessage();
        // pass 'true' to the constructor to create a multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(emailRequest.getToEmail());
        helper.setSubject(emailRequest.getSubject());
        helper.setText(emailRequest.getMessage());
        FileSystemResource file = new FileSystemResource(new File(emailRequest.getAttachment()));
        helper.addAttachment("Attachment", file);
        emailSender.send(message); 
        
        EmailService email= new EmailService(emailRequest.getMessage(),emailRequest.getAttachment(), emailRequest.getFromEmail(), emailRequest.getToEmail(), emailRequest.getSubject());
        emailRepository.save(email);
      
  return new ApiResponse(true, "Email sent Successfully");
        
    }
    

    
}
