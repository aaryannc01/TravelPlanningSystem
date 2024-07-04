package org.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DestinationRepository {
    private final MongoCollection<Document> destinationsCollection;

    public DestinationRepository(MongoDatabase database) {
        this.destinationsCollection = database.getCollection("destinations");
    }

    public void saveDestination(Destination destination) {
        Document doc = new Document("name", destination.getName())
                .append("description", destination.getDescription());
        destinationsCollection.insertOne(doc);
    }
}
