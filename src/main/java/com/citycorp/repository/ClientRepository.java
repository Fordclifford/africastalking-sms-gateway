package com.citycorp.repository;

import com.citycorp.model.Client;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author user
 */
 @Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
     
      Optional<Client> findById (Long id);
    
    
}