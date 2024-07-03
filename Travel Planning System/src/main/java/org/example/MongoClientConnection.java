package org.example;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
public class MongoClientConnection {
    public static void main(String[] args) {
        try {
            //Creating a mongo client
            ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
            MongoClient mongoClient = MongoClients.create(connectionString);
            System.out.println("Connected successfully!");
        } catch (MongoException me) {
            System.err.println(me);
        }
    }
}