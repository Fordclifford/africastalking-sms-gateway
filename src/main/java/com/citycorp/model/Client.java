package com.citycorp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "m_client")
public class Client {
	@Column(name = "id")
    @Id
	 private Long id;
	
	 @Column(name = "display_name")
	 private String displayName;
	 	 
	 @Column(name = "mobile_no")
	private String  mobileNo;
	 
	 

	public Client() {
		super();
	}

	public Client( String displayName, String mobileNo) {
		super();
		
		this.displayName = displayName;
		this.mobileNo = mobileNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	 
	

}
