package com.aar;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DestinationRepository {
    private MongoCollection<Destination> destinationCollection;

    public DestinationRepository(MongoDatabase database) {
        this.destinationCollection = database.getCollection("destinations", Destination.class);
    }

    public void save(Destination destination) {
        destinationCollection.insertOne(destination);
    }
}
