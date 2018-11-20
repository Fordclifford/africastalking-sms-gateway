/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citycorp.controller;
import com.africastalking.*;
import com.citycorp.model.SMS;

import com.citycorp.payload.ApiResponse;
import com.citycorp.payload.SMSRequest;
import com.citycorp.repository.SMSRepository;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
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
public class SMSController {
    
    @Autowired
    private SMSRepository smsRepository;
    
    private static final int HTTP_PORT = 8081;
    private static final int RPC_PORT = 35897;
    private static final String USERNAME = "city";
    private static final String API_KEY = "e22b2d9008e86e4c42d0c340ecbe4c17c75f0fbfc7d91ca9d715e30f4d11eea7";
    
     private static void log(String message) {
        System.out.println(message);
    }
     
    
    private static void setupAfricastalking() throws IOException {
         InetAddress host = Inet4Address.getLocalHost();
        log("\n");
        log(String.format("SDK Server: %s:%d", host.getHostAddress(), RPC_PORT));
        log(String.format("HTTP Server: %s:%d", host.getHostAddress(), HTTP_PORT));
        log("\n");


        AfricasTalking.initialize(USERNAME, API_KEY);
        AfricasTalking.setLogger(new Logger(){
            @Override
            public void log(String message, Object... args) {
                System.out.println(message);
            }
        });
           }
    
    
    @PostMapping("/sms/send")
    public ApiResponse sendSMS( @Valid @RequestBody SMSRequest smsRequest) throws IOException{
        setupAfricastalking();
        SMS text = new SMS(smsRequest.getPhone(), smsRequest.getMessage());
         SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
      
        	sms.send(smsRequest.getMessage(),null, new String[] {smsRequest.getPhone()},false);	       		
        smsRepository.save(text);     
        

  return new ApiResponse(true, "Message sent Successfully");
        
    }
    

    
}
