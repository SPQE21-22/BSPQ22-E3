package MongoConnector1;


//import org.junit.Rule;
import MongoConnector.MyConnector;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.*;
import static org.junit.Assert.*;

@PerfTest(invocations = 3)
@Required(max = 35000, average = 3000) // Max Execution time 10.5s and at most 3 avg. per execution
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