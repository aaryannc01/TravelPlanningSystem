package org.example;

import java.util.ArrayList;
import java.util.List;

public class Itinerary {
    private String userId;
    private String name;
    private List<Destination> destinations;

    public Itinerary(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.destinations = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
