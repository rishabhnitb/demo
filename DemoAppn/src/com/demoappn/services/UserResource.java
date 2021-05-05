package com.demoappn.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demoapp.persist.UserPersist;
import com.demoappn.dao.UserDAO;
import com.demoappn.mongo.DBInitialise;
import com.demoappn.pojos.User;

@Path("/users")
public class UserResource {

	
	private DBInitialise dao = DBInitialise.getInstance();
	private UserPersist persist = new UserPersist();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){
		
		return persist.getAllUsers(dao.getCollection());
	}
}
