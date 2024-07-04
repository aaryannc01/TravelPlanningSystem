package org.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;

import java.util.ArrayList;
import java.util.List;

public class ItineraryRepository {
    private final MongoCollection<Document> itinerariesCollection;

    public ItineraryRepository(MongoDatabase database) {
        this.itinerariesCollection = database.getCollection("itineraries");
    }

    public void saveItinerary(Itinerary itinerary) {
        List<Document> destinationDocs = new ArrayList<>();
        for (Destination destination : itinerary.getDestinations()) {
            destinationDocs.add(new Document("name", destination.getName())
                    .append("description", destination.getDescription()));
        }

        Document doc = new Document("userId", itinerary.getUserId())
                .append("name", itinerary.getName())
                .append("destinations", destinationDocs);
        itinerariesCollection.insertOne(doc);
    }

    public List<Itinerary> findItinerariesByUserId(String userId) {
        List<Itinerary> itineraries = new ArrayList<>();
        for (Document doc : itinerariesCollection.find(Filters.eq("userId", userId))) {
            Itinerary itinerary = new Itinerary(
                    doc.getString("userId"),
                    doc.getString("name")
            );

            List<Document> destinationDocs = (List<Document>) doc.get("destinations");
            for (Document destinationDoc : destinationDocs) {
                itinerary.addDestination(new Destination(
                        destinationDoc.getString("name"),
                        destinationDoc.getString("description")
                ));
            }

            itineraries.add(itinerary);
        }
        return itineraries;
    }
}
