package ModelPackage;

import org.junit.jupiter.api.Test;
//import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;
import static org.junit.jupiter.api.Assertions.*;

@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
class UserTest {
    //This activates contiperf
   // @Rule
    //public ContiPerfRule i = new ContiPerfRule();

    //Executes the test 300 times, regardless of the number of threads.
    @Test
    @PerfTest(invocations = 300)
    void userVerification() {
        User testUser = new User("Francisco","123456789");
        assertTrue(testUser.getValid());
    }
}