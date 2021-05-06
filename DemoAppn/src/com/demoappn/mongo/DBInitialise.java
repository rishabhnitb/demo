package com.demoappn.mongo;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
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
		 
		
		
		MongoClient mongoClient = MongoClients.create(
			    "mongodb+srv://demo:demo123@cluster0.cbuby.mongodb.net/database?"
			    + "retryWrites=true&w=majority");
			MongoDatabase database = mongoClient.getDatabase("database");
			MongoCollection<Document> collection = database.getCollection("collection");
	     
	     return collection;
	}
}
