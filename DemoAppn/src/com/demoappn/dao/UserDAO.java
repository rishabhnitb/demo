package com.demoappn.dao;

import java.util.ArrayList;
import java.util.List;

import com.demoappn.pojos.User;

public class UserDAO {

	private static UserDAO instance;
	private static List<User> userList = new ArrayList<>();
	
	static {
		
		userList.add(new User("user1", "user1@mail.com"));
		userList.add(new User("user2", "user2@mail.com"));
		userList.add(new User("user3", "user3@mail.com"));
		userList.add(new User("user4", "user4@mail.com"));
		userList.add(new User("user5", "user5@mail.com"));
	}
	
	public static UserDAO getInstance() {
		
		if(instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	public List<User> listAll(){
		
		return new ArrayList<User>(userList);
	}
}
