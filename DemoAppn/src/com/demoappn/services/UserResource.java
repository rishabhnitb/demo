package com.demoappn.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demoappn.dao.UserDAO;
import com.demoappn.pojos.User;

@Path("/users")
public class UserResource {

	
	private UserDAO dao = UserDAO.getInstance();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){
		
		return dao.listAll();
	}
}
