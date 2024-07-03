package org.example;

import java.util.List;

public class Itinerary {
    private String id;
    private String userId;
    private String title;
    private List<String> destinationIds;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<String> getDestinationIds() { return destinationIds; }
    public void setDestinationIds(List<String> destinationIds) { this.destinationIds = destinationIds; }
}
