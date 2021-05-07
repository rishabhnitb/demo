package com.demoapp.persist;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.demoappn.pojos.Review;
import com.demoappn.pojos.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class UserPersist {

	
	public List<User> createUser(User user,  MongoCollection<Document> collection){
		
		collection.insertOne(this.setUser(user));
		return getAllUsers(collection);
	}
	
	public Document setUser(User user) {
		//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//Date date = new Date();
		Document doc = new Document("name", user.getName()).
				append("mail", user.getMail()).
				append("key", user.getKey()).
				append("createdAt", new Timestamp(System.currentTimeMillis())).
				append("updatedAt", new Timestamp(System.currentTimeMillis()));
		
		return doc;
	}
	
	public List<User> getUser(MongoCollection<Document> collection, String mail) {
		
	
		 BasicDBObject obj = new BasicDBObject();        
		 obj.append("mail", mail);     
		 BasicDBObject query = new BasicDBObject();        
		 query.putAll((BSONObject)obj);
	   
		 FindIterable<Document> documents = collection.find(query);
		 return fetchUsers(documents);
	}
	
	public List<User> getAllUsers(MongoCollection<Document> collection){
		
		
		// Performing a read operation on the collection.
	    FindIterable<Document> documents = collection.find();
		
	    return fetchUsers(documents);
	}
	

	public List<User> fetchUsers(FindIterable<Document> documents){
		
		MongoCursor<Document> cursor = documents.iterator();
		List<User> users = new ArrayList<User>();
		 while(cursor.hasNext()) {
			 
			 Document doc = cursor.next();
			 User user = new User();
			 ObjectId id = doc.getObjectId("_id");
			 user.setUserID(id.toString());
			 user.setName(doc.getString("name"));
			 user.setKey(doc.getString("key"));
			 user.setMail(doc.getString("mail"));
			 user.setCreatedAt(doc.getDate("createdAt"));
			 user.setUpdatedAt(doc.getDate("updatedAt"));
			 users.add(user);
		 }
		 return users;
	}

	public List<User> getUserReviews(String userID, MongoCollection<Document> userCollection,
			MongoCollection<Document> reviewCollection) {
		
		 BasicDBObject objUser = new BasicDBObject();        
		 objUser.append("_id", new ObjectId(userID));     
		 BasicDBObject queryUser = new BasicDBObject();        
		 queryUser.putAll((BSONObject)objUser);
		 FindIterable<Document> documentUser = userCollection.find(queryUser);
		 List<User> user = fetchUsers(documentUser);
		 
		 BasicDBObject obj = new BasicDBObject();        
		 obj.append("createdBy", userID);     
		 BasicDBObject query = new BasicDBObject();        
		 query.putAll((BSONObject)obj);
		 FindIterable<Document> documentReview = reviewCollection.find(query);
		 
		 ReviewPersist reviewPersist = new ReviewPersist();
		 List<Review> reviews = reviewPersist.fetchReviews(documentReview);
		 
		 user.get(0).setReviews(reviews);
		 return user;
		 
	}
	
	
}
