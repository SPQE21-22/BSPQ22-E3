package ModelPackage;

import MongoConnector.MyConnector;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javafx.scene.control.TextField;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static ApplicationPackage.Main.connector;

/**
 * User class attributes
 */
public class User {

    private String username;
    private String password;
    private String first_name = "";
    private String last_name = "";
    private String id;
    private Boolean valid;
    public ArrayList<String> likes_list = new ArrayList<String>();
    /**
     * User class logger
     */
    Logger logger = LoggerFactory.getLogger(User.class);
    //Constructors:

    public User(String username, String password) {
        if (connector == null) {
            connector = new MyConnector();
        }
        this.username = username;
        this.password = password;
        valid = userVerification();
    }


    public void clear(User user){
        if (connector == null) {
            connector = new MyConnector();
        }
        this.username = "";
        this.password = "";
    }

    /**
     * Getters of the user class
     */
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public Boolean getValid() {
        return valid;
    }

    public String getFirst_name() {return first_name; }

    public String getLast_name() {
        return last_name;
    }

    public ArrayList<String> getLikes_list() { return likes_list;}

    /**
     * Setters of the user class
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setLikes_list(ArrayList<String> likes_list) { this.likes_list = likes_list;}

    /**
     *Helpers method of the user class
     */
    public Boolean userVerification(){
        /**
         * User verification when login
         */
        MongoCollection<Document> col = connector.db.getCollection("Credentials");
        BasicDBObject query = new BasicDBObject();
        query.put("username",this.username);
        query.put("password",this.password);

        /**
         * Gets user attributes values for the login
         */
        try (MongoCursor<Document> cursor = col.find(query).iterator()) {
            valid = cursor.hasNext();
            if (valid){
                Document obj = cursor.next();
                this.id = obj.get("_id").toString();
                this.first_name = obj.get("first_name").toString();
                this.last_name = obj.get("last_name").toString();
            }
        }

        //System.out.println("Matched Credentials? : "+valid);
        logger.info("Matched Credentials? : "+valid);
        return valid;


    }

    /**
     * Method that checks the maximum amount of the list of likes

     */
    public boolean checkLikesListSize() {

        return (likes_list.size() < 3);
    }

}
