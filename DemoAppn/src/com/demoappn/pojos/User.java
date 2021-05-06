package com.demoappn.pojos;

import java.security.Timestamp;
import java.util.Date;

public class User {

	
	private String name;
	
	private String mail;
	
	private String key;
	
	private String userID;

	private Date createdAt;
	
	private Date updatedAt;
	
	
	public User() {
		super();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String id) {
		this.userID = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
