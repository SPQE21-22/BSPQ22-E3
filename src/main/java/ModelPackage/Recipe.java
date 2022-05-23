package ModelPackage;

import MongoConnector.MyConnector;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.types.Decimal128;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ApplicationPackage.Main.connector;

public class Recipe {

    private String recipe_id;
    private String title;
    private Decimal128 calories;
    private Decimal128 carbohydrates;
    private Decimal128 fats;
    private Decimal128 proteins;
    private long likes_count;
    private long readyInMinutes;
    private String image;
    private String imageType;
    private String sourceURL;
    private Boolean valid;
    private boolean flag;
    private String input;

    Logger logger = LoggerFactory.getLogger(User.class);

    public Recipe(String input) {
        this.input = input;
        this.flag = (input.length()==3);
        valid = recipeVerification();
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

    public Decimal128 getCalories() {
        return calories;
    }

    public void setCalories(Decimal128 calories) {
        this.calories = calories;
    }

    public Decimal128 getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Decimal128 carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Decimal128 getFats() {
        return fats;
    }

    public void setFats(Decimal128 fats) {
        this.fats = fats;
    }

    public Decimal128 getProteins() {
        return proteins;
    }

    public void setProteins(Decimal128 proteins) {
        this.proteins = proteins;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public long getlikes_count() {
        return likes_count;
    }

    public void setlikes_count(long likes_count) {
        this.likes_count = likes_count;
    }

    public long getReadyInMinutes() {
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
    public Boolean recipeVerification(){
        if (connector == null) {
            connector = new MyConnector();
        }
        MongoCollection<Document> col = connector.db.getCollection("Recipe");

        BasicDBObject query = new BasicDBObject();
        if (flag){
            query.put("Recipe_Id", input);
        }

        else {
            query.put("Title", input);
        }

        try (MongoCursor<Document> cursor = col.find(query).iterator()) {
            valid = cursor.hasNext();
            if (valid){
                Document obj = cursor.next();

                this.recipe_id = obj.get("Recipe_Id").toString();
                this.title = obj.get("Title").toString();
                this.calories = (Decimal128) obj.get("Calories");
                this.carbohydrates = (Decimal128) obj.get("Carbohydrates");
                this.fats = (Decimal128) obj.get("Fats");
                this.proteins = (Decimal128) obj.get("Proteins");
                this.likes_count = (long) obj.get("Likes");
                this.readyInMinutes = (long) obj.get("readyInMinutes");
                this.image = obj.get("image").toString();
                this.imageType = obj.get("imageType").toString();
                this.sourceURL = obj.get("sourceURL").toString();



            }
        }

        //System.out.println("Matched Credentials? : "+valid);
        logger.info("Matched Recipe Data? : "+valid);
        return valid;
    }
}
