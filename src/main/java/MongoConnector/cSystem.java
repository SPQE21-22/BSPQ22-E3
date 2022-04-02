package MongoConnector;

public interface cSystem {
    static String Cluster_Username = "group3";
    static String Cluster_Password = "group3";
    static String Connection_Uri  = "mongodb+srv://"+Cluster_Username+":"+Cluster_Password+"@cluster0.zr68o.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
    String DB_Name = "appDB";
    String Col_Name = "Collection1";

}
