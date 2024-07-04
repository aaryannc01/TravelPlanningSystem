package org.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;

public class UserRepository {
    private final MongoCollection<Document> usersCollection;

    public UserRepository(MongoDatabase database) {
        this.usersCollection = database.getCollection("users");
    }

    public void saveUser(User user) {
        Document doc = new Document("email", user.getEmail())
                .append("password", user.getPassword());
        usersCollection.insertOne(doc);
    }

    public User findUserByEmail(String email) {
        Document doc = usersCollection.find(Filters.eq("email", email)).first();
        if (doc != null) {
            User user = new User(doc.getString("email"), doc.getString("password"));
            user.setId(doc.getObjectId("_id").toString());
            return user;
        }
        return null;
    }
}
