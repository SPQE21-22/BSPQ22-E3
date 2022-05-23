package ModelPackage1;


//import org.junit.Rule;
import ModelPackage.User;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.*;
import static org.junit.Assert.*;


@PerfTest(invocations = 5)
@Required(max = 2500, average = 250)
public class UserTest {
    //This activates contiperf
    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    //Executes the test 50 times, regardless of the number of threads.
    @Test
    @PerfTest(invocations = 50)
    public void userVerification() {
        User testUser = new User("Francisco","123456789");
        assertTrue(testUser.getValid());
    }
}