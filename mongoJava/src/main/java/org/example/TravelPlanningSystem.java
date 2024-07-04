package org.example;

import com.mongodb.client.MongoDatabase;

import java.util.Scanner;

public class TravelPlanningSystem {
    public static void main(String[] args) {
        // Establish a connection to the MongoDB database
        MongoDatabase database = MongoClientConnection.getDatabase();

        // Initialize repositories with the database connection
        UserRepository userRepository = new UserRepository(database);
        DestinationRepository destinationRepository = new DestinationRepository(database);
        ItineraryRepository itineraryRepository = new ItineraryRepository(database);

        // Initialize controllers with the repositories
        UserController userController = new UserController(userRepository);
        ItineraryController itineraryController = new ItineraryController(itineraryRepository);

        Scanner scanner = new Scanner(System.in);

        // Example interaction
        System.out.println("Welcome to the Travel Planning System!");

        // Register a new user
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        userController.registerUser(email, password);

        // Log in the user
        System.out.print("Enter your email to log in: ");
        String loginEmail = scanner.nextLine();
        System.out.print("Enter your password to log in: ");
        String loginPassword = scanner.nextLine();
        String userId = userController.loginUser(loginEmail, loginPassword);

        if (userId != null) {
            System.out.println("Login successful!");

            // Create a new itinerary for the logged-in user
            System.out.print("Enter a name for your itinerary: ");
            String itineraryName = scanner.nextLine();
            itineraryController.createItinerary(userId, itineraryName);

            // Add destinations to the itinerary
            System.out.print("Enter a destination name: ");
            String destinationName = scanner.nextLine();
            System.out.print("Enter a description for the destination: ");
            String destinationDescription = scanner.nextLine();
            itineraryController.addDestinationToItinerary(userId, destinationName, destinationDescription);

            // Retrieve and print user itineraries
            itineraryController.getUserItineraries(userId);
        } else {
            System.out.println("Login failed. Please check your email and password.");
        }

        // Close the MongoDB connection
        MongoClientConnection.close();
        scanner.close();
    }
}
