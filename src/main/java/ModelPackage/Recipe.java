package ModelPackage;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ApplicationPackage.Main.connector;

public class Recipe {

    private String recipe_id;
    private String title;
    private float calories;
    private float carbohydrates;
    private float fats;
    private float proteins;
    private int likes;
    private int readyInMinutes;
    private String image;
    private String imageType;
    private String sourceURL;
    private Boolean valid;

    Logger logger = LoggerFactory.getLogger(User.class);

    public Recipe(String recipe_id, String title, float calories, float carbohydrates, float fats, float proteins, int likes, int readyInMinutes, String image, String imageType, String sourceURL) {
        this.recipe_id = recipe_id;
        this.title = title;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.proteins = proteins;
        this.likes = likes;
        this.readyInMinutes = readyInMinutes;
        this.image = image;
        this.imageType = imageType;
        this.sourceURL = sourceURL;
    }
    public Recipe() {
        this.recipe_id = "";
        this.title = "";
        this.calories = 0;
        this.carbohydrates = 0;
        this.fats = 0;
        this.proteins = 0;
        this.likes = 0;
        this.readyInMinutes = 0;
        this.image = "";
        this.imageType = "";
        this.sourceURL = "";
    }
    //Getters and Setters
    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public float getFats() {
        return fats;
    }

    public void setFats(float fats) {
        this.fats = fats;
    }

    public float getProteins() {
        return proteins;
    }

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }
    //Helper Methods:
    public Boolean userVerification(){

        MongoCollection<Document> col = connector.db.getCollection("Recipe");
        BasicDBObject query = new BasicDBObject();



        try (MongoCursor<Document> cursor = col.find(query).iterator()) {
            valid = cursor.hasNext();
            if (valid){
                Document obj = cursor.next();
                this.recipe_id = obj.get("_id").toString();
                this.title = obj.get("_id").toString();
                this.calories = Float.parseFloat(obj.get("_id").toString());
                this.carbohydrates = Float.parseFloat(obj.get("_id").toString());
                this.fats = Float.parseFloat(obj.get("_id").toString());
                this.proteins = Float.parseFloat(obj.get("_id").toString());
                this.likes = Integer.parseInt(obj.get("_id").toString());
                this.readyInMinutes = Integer.parseInt(obj.get("_id").toString());
                this.image = obj.get("_id").toString();
                this.imageType = obj.get("_id").toString();
                this.sourceURL = obj.get("_id").toString();



            }
        }

        //System.out.println("Matched Credentials? : "+valid);
        logger.info("Matched Recipe Data? : "+valid);
        return valid;
    }
}
