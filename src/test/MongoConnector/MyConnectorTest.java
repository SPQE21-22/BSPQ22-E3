package MongoConnector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyConnectorTest {
// Executes the test repeatedly for at least 10,000 milliseconds (10 seconds)
    @Test
    @PerfTest(duration = 10000)
    void testMyConnector(){
        MyConnector m = new MyConnector();
        String connectedString = "Connected to -> appDB";
        String testString = m.statusToString(m.db);

        Boolean success = testString.contains(connectedString);
        assertEquals(true,success);
    }

    
}