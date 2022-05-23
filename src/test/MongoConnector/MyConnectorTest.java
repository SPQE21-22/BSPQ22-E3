package MongoConnector;


//import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.*;
import static org.junit.Assert.*;

@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class MyConnectorTest {
    //This activates contiperf
    @Rule
    public ContiPerfRule i = new ContiPerfRule();
    // Executes the test repeatedly for at least 10,000 milliseconds (10 seconds)
    @Test
    @PerfTest(duration = 10000)
    public void MyConnectorJTest(){
        MyConnector m = new MyConnector();
        String connectedString = "Connected to -> appDB";
        String testString = m.statusToString(m.db);

        Boolean success = testString.contains(connectedString);
        assertEquals(true,success);
    }

    
}