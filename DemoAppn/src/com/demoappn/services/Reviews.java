package com.demoappn.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demoapp.persist.ReviewPersist;
import com.demoappn.mongo.DBInitialise;
import com.demoappn.pojos.Review;

@Path("/reviews")
public class Reviews {

	
	private DBInitialise dao = DBInitialise.getInstance();
	private ReviewPersist persist = new ReviewPersist();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Review> getAllReview(){
		
		List<Review> reviews = new ArrayList<Review>();
		reviews = persist.getAllReviews(dao.getCollection(2));
		return reviews;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Review> addReview(Review review){
		
		List<Review> reviews = new ArrayList<Review>();
		reviews = persist.addReview(dao.getCollection(2), review);
		return reviews;
	}
}
