package ModelPackage;


//import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.junit.*;
import static org.junit.Assert.*;


@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
class UserTest {
    //This activates contiperf
   // @Rule
    //public ContiPerfRule i = new ContiPerfRule();

    //Executes the test 300 times, regardless of the number of threads.
    @Test
    @PerfTest(invocations = 300)
    public void userVerification() {
        User testUser = new User("Francisco","123456789");
        assertTrue(testUser.getValid());
    }
}