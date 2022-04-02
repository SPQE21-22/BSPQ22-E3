package MongoConnector;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MyConnector implements cSystem {

    public MyConnector(){
        ConnectionString connectionString = new ConnectionString(cSystem.Connection_Uri);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase db = mongoClient.getDatabase(cSystem.DB_Name);
        System.out.printf("Connected to: %s ", db.getName());
    }





}
