package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItineraryController {
    private ItineraryRepository itineraryRepository;
    private Scanner scanner = new Scanner(System.in);

    public ItineraryController(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public void createItinerary(String userId) {
        System.out.println("Enter itinerary title: ");
        String title = scanner.nextLine();

        Itinerary itinerary = new Itinerary();
        itinerary.setUserId(userId);
        itinerary.setTitle(title);

        List<String> destinationIds = new ArrayList<>();
        System.out.println("Enter destination IDs (comma separated): ");
        String[] ids = scanner.nextLine().split(",");
        for (String id : ids) {
            destinationIds.add(id.trim());
        }
        itinerary.setDestinationIds(destinationIds);

        itineraryRepository.save(itinerary);
        System.out.println("Itinerary created successfully.");
    }

    public void getUserItineraries(String userId) {
        List<Itinerary> itineraries = itineraryRepository.findByUserId(userId);
        for (Itinerary itinerary : itineraries) {
            System.out.println("Itinerary Title: " + itinerary.getTitle());
            // Display more details as needed...
        }
    }
}
