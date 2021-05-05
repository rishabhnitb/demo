package com.demoappn.pojos;


public class User {

	
	private String name;
	
	private String mail;
	
	private String userID;

	
	
	public User() {
		super();
		
	}

	public User(String name, String mail, String id) {
		super();
		this.name = name;
		this.mail = mail;
		this.userID = id;
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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String id) {
		this.userID = id;
	}
	
	
}
