package com.demoapp.persist;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.demoappn.pojos.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class UserPersist {

	
	public List<User> createUser(User user,  MongoCollection<Document> collection){
		
		collection.insertOne(this.setUser(user));
		return getAllUsers(collection);
	}
	
	public Document setUser(User user) {
		
		Document doc = new Document("name", user.getName()).
				append("mail", user.getMail()).
				append("userID", UUID.randomUUID());
		
		return doc;
	}
	
	public List<User> getAllUsers(MongoCollection<Document> collection){
		
		
		// Performing a read operation on the collection.
	    FindIterable<Document> documents = collection.find();
		
		MongoCursor<Document> cursor = documents.iterator();
		List<User> users = new ArrayList<User>();
		 while(cursor.hasNext()) {
			 
			 Document doc = cursor.next();
			 User user = new User();
			 ObjectId id = doc.getObjectId("_id");
			 user.setUserID(doc.getString(id.toString()));
			 user.setName(doc.getString("name"));
			 user.setMail(doc.getString("mail"));
			 users.add(user);
		 }
		 return users;
	}
}
