package com.demoappn.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demoapp.persist.UserPersist;
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
	
	@GET
	@Path("{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getSingeleUser(@PathParam("userID") String userID){
		
		return persist.getUser(dao.getCollection(), userID);
	}
	
	@POST
	@Path("user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> createUser(User user){
		
		return persist.createUser(user, dao.getCollection());
	}
	
}
