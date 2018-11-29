package com.citycorp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "m_loan")
public class Loan {
	@Column(name = "id")
    @Id
	 private Long id;
	
	 @Column(name = "client_id")
	 private Long clientId;
	 	 
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	

}
