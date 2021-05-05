package com.demoappn.pojos;

import java.util.UUID;

public class User {

	
	private String name;
	
	private String mail;
	
	private UUID userID;

	public User(String name, String mail) {
		super();
		this.name = name;
		this.mail = mail;
		this.userID = UUID.randomUUID();
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

	public UUID getUserID() {
		return userID;
	}

	public void setUserID() {
		this.userID = UUID.randomUUID();
	}
	
	
}
