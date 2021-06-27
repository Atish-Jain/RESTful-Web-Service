package com.example;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usersContact")
public class UsersContact {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="id")
	 private Integer id;
	 @Column(name="phoneNo")
	 private Integer phoneNo;
	 
	public Integer getId() {
		return id;
	}
	public UsersContact setId(Integer id) {
		this.id = id;
		return this;
	}
	public Integer getPhoneNo() {
		return phoneNo;
	}
	public UsersContact setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
		return this;
	}
	public UsersContact() {
		
		
	}
	
	
	 
	 
	
}
