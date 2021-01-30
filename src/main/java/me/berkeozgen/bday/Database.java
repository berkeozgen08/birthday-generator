package me.berkeozgen.bday;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Database {
	
	private static MongoClient mongoClient;
	private static MongoDatabase database;
	private static MongoCollection<Document> collection;

	static {
		mongoClient = MongoClients.create(System.getenv("MONGODB_URI"));
		database = mongoClient.getDatabase("bday");
		collection = database.getCollection("bday");
	}

	public static String saveToDB(String to, String bdaymsg, String msg) {
		String slug = NanoID.generate(5);
		Document document = new Document("to", to)
								.append("bdaymsg", bdaymsg)
								.append("msg", msg)
								.append("slug", slug)
								.append("time", System.currentTimeMillis());
		collection.insertOne(document);
		return slug;
	}

	public static Document findSlug(String slug) {
		Document query = new Document("slug", slug);
		if (collection.countDocuments(query) > 0) {
			return collection.find(query).first();
		} else {
			return null;
		}
	}

}
