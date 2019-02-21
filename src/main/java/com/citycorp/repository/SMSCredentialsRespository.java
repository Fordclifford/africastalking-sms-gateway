package com.citycorp.repository;

import com.citycorp.model.SMSCredentials;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author user
 */
 @Repository
public interface SMSCredentialsRespository extends JpaRepository<SMSCredentials,Long> {
     
	  @Query(
			  value = "SELECT *  FROM `sms_credentials` where `id`=1",
			  nativeQuery = true)
	  List<SMSCredentials> getApiKeyandUsername ();
	  
	  @Query(
			  value = "SELECT  username FROM `sms_credentials` where `id`=1",
			  nativeQuery = true)
	            Optional<String> getUserName ();

	SMSCredentials findById(int i);
}
    
    