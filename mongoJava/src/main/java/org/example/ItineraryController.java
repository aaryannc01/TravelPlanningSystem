package org.example;

import java.util.List;

public class ItineraryController {
    private final ItineraryRepository itineraryRepository;

    public ItineraryController(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public void createItinerary(String userId, String name) {
        Itinerary itinerary = new Itinerary(userId, name);
        itineraryRepository.saveItinerary(itinerary);
        System.out.println("Itinerary created successfully.");
    }

    public void addDestinationToItinerary(String userId, String destinationName, String description) {
        List<Itinerary> itineraries = itineraryRepository.findItinerariesByUserId(userId);
        if (!itineraries.isEmpty()) {
            Itinerary itinerary = itineraries.get(0); // Assumption: Add to the first itinerary
            itinerary.addDestination(new Destination(destinationName, description));
            itineraryRepository.saveItinerary(itinerary);
            System.out.println("Destination added successfully.");
        } else {
            System.out.println("No itineraries found for user.");
        }
    }

    public void getUserItineraries(String userId) {
        List<Itinerary> itineraries = itineraryRepository.findItinerariesByUserId(userId);
        if (!itineraries.isEmpty()) {
            for (Itinerary itinerary : itineraries) {
                System.out.println("Itinerary: " + itinerary.getName());
                for (Destination destination : itinerary.getDestinations()) {
                    System.out.println("  Destination: " + destination.getName() +
                            " - " + destination.getDescription());
                }
            }
        } else {
            System.out.println("No itineraries found for user.");
        }
    }
}
