package org.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;

public class ItineraryRepository {
    private MongoCollection<Itinerary> itineraryCollection;

    public ItineraryRepository(MongoDatabase database) {
        this.itineraryCollection = database.getCollection("itineraries", Itinerary.class);
    }

    public void save(Itinerary itinerary) {
        itineraryCollection.insertOne(itinerary);
    }

    public List<Itinerary> findByUserId(String userId) {
        return itineraryCollection.find(eq("userId", userId)).into(new ArrayList<>());
    }
}
