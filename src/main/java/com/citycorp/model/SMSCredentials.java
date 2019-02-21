package com.citycorp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "sms_credentials")
public class SMSCredentials {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	   
	    private String apiKey;

	    
	   
	    private String username;



		public String getApiKey() {
			return apiKey;
		}



		public void setApiKey(String apiKey) {
			this.apiKey = apiKey;
		}



		public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}



		public SMSCredentials(String apiKey, String username) {
			super();
			this.apiKey = apiKey;
			this.username = username;
		}
	    

}
