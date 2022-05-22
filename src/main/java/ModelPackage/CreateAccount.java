package ModelPackage;

import MongoConnector.MyConnector;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ApplicationPackage.Main.connector;

public class CreateAccount {
    public String errorMessage = "";
    Logger logger = LoggerFactory.getLogger(CreateAccount.class);

    public CreateAccount(){
        if (connector == null){
            connector = new MyConnector();
        }
    }

    /**
     * Method to create a new account
     */
    public Boolean newAccountVerification(String username, String password, String first_name, String last_name){
        /**
         * First create the user with the required attributes
         */
        if (username.equals("")|| password.equals("") || first_name.equals("") || last_name.equals("")){
            errorMessage = "Please complete ALL text fields";
            return false;
        }
        /**
         * Else the user is already in use
         */
        else if (userNameCheck(username))
        {
            errorMessage = "Sorry, that username is already in use.";
            return false;
        }
        /**
         * Else create a new account
         */
        else {
            writeNewAccount(username,password,first_name,last_name);
            return true;}
    }

    /**
     * Method that checks the username with the DB
     */
    public Boolean userNameCheck(String username) {
        MongoCollection<Document> col = connector.db.getCollection("Credentials");
        BasicDBObject query = new BasicDBObject();
        query.put("username", username);
        boolean valid = false;
        try (MongoCursor<Document> cursor = col.find(query).iterator()) {
            valid = cursor.hasNext();
        }
        return valid;
    }

    /**
     * Method that creates a new account in the DB
     */
    public void writeNewAccount(String username, String password, String first_name, String last_name){
        Document document = new Document();
        document.append("username", username);
        document.append("password", password);
        document.append("first_name", first_name);
        document.append("last_name", last_name);
        connector.db.getCollection("Credentials").insertOne(document);
        //System.out.println("Account created successfully");
        logger.info("Account created successfully");
    }
    /**
     * Method that removes an existing account in the DB
     */
    public void removeOneAccount(String username, String password, String first_name, String last_name){
        Document document = new Document();
        document.append("username", username);
        document.append("password", password);
        document.append("first_name", first_name);
        document.append("last_name", last_name);
        connector.db.getCollection("Credentials").deleteOne(document);
        //System.out.println("Account deleted");
        logger.info("Account deleted successfully");
    }


}
