package com.demoappn.dao;

import java.util.ArrayList;
import java.util.List;

import com.demoappn.pojos.User;

public class UserDAO {

	private static UserDAO instance;
	private static List<User> userList = new ArrayList<>();
	
	static {
		
		userList.add(new User("vatican city", "vc@mail.com"));
		userList.add(new User("taj mahal", "tj@mail.com"));
		userList.add(new User("red fort", "rf@mail.com"));
		userList.add(new User("rahul gandhi", "raga@mail.com"));
		userList.add(new User("summer rey", "srey@mail.com"));
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
