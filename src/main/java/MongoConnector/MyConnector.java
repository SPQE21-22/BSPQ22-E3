package MongoConnector;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.nio.file.FileVisitResult;
import java.util.ArrayList;

public class MyConnector implements cSystem {
    private ArrayList<String> col_Names = new ArrayList<>();
    public MongoDatabase db;

    // Constructors:
    public MyConnector(){
        try {
            ConnectionString connectionString = new ConnectionString(cSystem.Connection_Uri);
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .build();
            MongoClient mongoClient = MongoClients.create(settings);
            db = mongoClient.getDatabase(cSystem.DB_Name);
            setCol_Names(db);
            statusToString(db);

        } catch (Exception e) {
            System.err.println("ERROR: Something went wrong in MyConnector.java");
            e.printStackTrace();
        }

    }
    // Getters:
    public ArrayList<String> getCol_Names() {
        return col_Names;
    }

    // Setters:
    public void setCol_Names(MongoDatabase db) {
        for (Object i: db.listCollectionNames()) {
            this.col_Names.add(i.toString());
        }
    }
    public void setCol_Names(ArrayList<String> col_Names) {
        this.col_Names = col_Names;
    }



    // Helper Methods:



    //toStrings:
    public void statusToString(MongoDatabase db){
        String divider = "-------------------------\n";

        String s = "CONNECTION STATUS: \n" +
                divider +
                String.format("Connected to -> %s \n", db.getName()) +
                String.format("Available Collections: \n%s\n", col_Names.toString()) +
                divider;

        System.out.print(s);
    }
}
