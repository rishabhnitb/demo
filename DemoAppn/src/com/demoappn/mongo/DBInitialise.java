package com.demoappn.mongo;

import org.bson.Document;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBInitialise {

	
	private static DBInitialise instance;
	public static DBInitialise getInstance() {
		
		if(instance == null) {
			instance = new DBInitialise();
		}
		return instance;
	}
	
	public MongoCollection<Document> getCollection(){
		 
		
		//MongoClient mongoClient = MongoClients.create();
		//MongoDatabase database = mongoClient.getDatabase("database");
		// MongoCollection<Document> collection = database.getCollection("users");

//		MongoClient mongoClient = MongoClients.create("mongodb+srv://demo:demo123@cluster0.cbuby.mongodb.net/"
//				+ "database?retryWrites=true&w=majority");
//		
	     // Accessing the database 
	    // MongoDatabase database = mongoClient.getDatabase("database");
	     //MongoCollection<Document> collection = database.getCollection("collection");
		 
		 MongoClientURI uri = new MongoClientURI(
				    "mongodb+srv://demo:demo123@cluster0.cbuby.mongodb.net/database?retryWrites=true&w=majority");
				com.mongodb.MongoClient mongoClient = new com.mongodb.MongoClient(uri);
				MongoDatabase database = mongoClient.getDatabase("test");
				MongoCollection<Document> collection = database.getCollection("collection");
	     
	     return collection;
	}
}
