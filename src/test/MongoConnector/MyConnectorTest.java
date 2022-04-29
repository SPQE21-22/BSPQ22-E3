package MongoConnector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyConnectorTest {

    @Test
    void testMyConnector(){
        MyConnector m = new MyConnector();
        String connectedString = "Connected to -> appDB";
        String testString = m.statusToString(m.db);

        Boolean success = testString.contains(connectedString);
        assertEquals(true,success);
    }

    
}