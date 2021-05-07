package com.demoapp.persist;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.demoappn.pojos.Review;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class ReviewPersist {

	public List<Review> getAllReviews(MongoCollection<Document> collection) {
		
		// Performing a read operation on the collection.
	    FindIterable<Document> documents = collection.find();
		
	    return fetchReviews(documents);
	}

	public List<Review> fetchReviews(FindIterable<Document> documents) {
		
		MongoCursor<Document> cursor = documents.iterator();
		List<Review> reviews = new ArrayList<Review>();
		while(cursor.hasNext()) {
			
			Document doc = cursor.next();
			Review review = new Review();
			ObjectId id = doc.getObjectId("_id");
			review.setReviewID(id.toString());
			review.setCreatedAt(doc.getDate("createdAt"));
			review.setUpdatedAt(doc.getDate("updatedAt"));
			review.setCreatedBy(doc.getString("createdBy"));
			review.setObjectClass(doc.getInteger("objectClass"));
			review.setReview(doc.getString("review"));
			review.setLocation(doc.getString("location"));
			
			reviews.add(review);
		}
		
		return reviews;
	}

	public List<Review> addReview(MongoCollection<Document> collection, Review review) {
		
		collection.insertOne(this.setReview(review));
		return getAllReviews(collection);
	}

	private Document setReview(Review review) {
		
		Document doc = new Document("objectClass", review.getObjectClass()).
				append("review", review.getReview()).
				append("location", review.getLocation()).
				append("createdBy", review.getCreatedBy()).
				append("createdAt",  new Timestamp(System.currentTimeMillis())).
				append("updatedAt",  new Timestamp(System.currentTimeMillis()));
		
		return doc;
	}

	
	
}
