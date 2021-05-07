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
		List<User> users = persist.getAllUsers(dao.getCollection(1));
		return users;
	}
	
	@GET
	@Path("{mail}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getSingeleUser(@PathParam("mail") String mail){
		
		return persist.getUser(dao.getCollection(1), mail);
	}
	
	@GET
	@Path("/user/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserDetails(@PathParam("userID") String userID){
		
		return persist.getUserReviews(userID, dao.getCollection(1), dao.getCollection(2));
	}
	
	@POST
	@Path("user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> createUser(User user){
		
		return persist.createUser(user, dao.getCollection(1));
	}
	
}
