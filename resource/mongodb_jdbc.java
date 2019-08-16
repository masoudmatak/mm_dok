package com.mkyong.core;

import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * Java + MongoDB Hello world Example
 * 
 */
public class App2 {
	public static void main(String[] args) {

		try {

			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("mydb");

			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection("customers");

			String namnetInneh="Arash Kamangir";
			/**** Insert ****/
			// create a document to store key and value
			BasicDBObject document = new BasicDBObject();
			document.put("name", namnetInneh);
			document.put("age", 40);
			document.put("Address", "Kungsgatan 45");
			document.put("createdDate", new Date());
			table.insert(document);


			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", namnetInneh);

			DBCursor cursor = table.find(searchQuery);

			
			
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}

			
			BasicDBObject query = new BasicDBObject();
			query.put("name", namnetInneh);

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("name", namnetInneh+"2");

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			table.update(query, updateObj);

			/**** Find and display ****/
			BasicDBObject searchQuery2 
				= new BasicDBObject().append("name", namnetInneh+"2");

			DBCursor cursor2 = table.find(searchQuery2);

			while (cursor2.hasNext()) {
				System.out.println(cursor2.next());
			}

			/**** Done ****/
			System.out.println("Done");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}
