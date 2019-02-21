package com.citycorp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "city_century")
public class Century {
	@Column(name = "id")
    @Id
	 private Long id;
	private String client_name;
	private Long loan_id;
	
	

}
