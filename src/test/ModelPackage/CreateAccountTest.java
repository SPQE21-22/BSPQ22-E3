package ModelPackage;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class CreateAccountTest {

    @Rule
    public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());


    //The test should be executed 1000 times with 20 concurrent threads, so each thread does 50 invocations.
    //In addition, a maximum execution time of 1.2 seconds and an average below or equals 250 milliseconds are tolerated
    @Test
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 250)
    public void writeNewAccount() {
        CreateAccount c = new CreateAccount();
        boolean success = c.newAccountVerification("thisisaTestAccount2", "thisisaTestPassword!", "testname", "testLastName");
        assertTrue(success);
    }

    // Requires that 50% of all executions do not take longer than 45 milliseconds
    @Test
    @Required(median = 45)
    public void checkRepeatedUsername(){
        CreateAccount c = new CreateAccount();
        boolean success = c.userNameCheck("Francisco");
        assertTrue(success);
    }

    //Requires that 95% of all executions do not take longer than 4000 milliseconds
    @Test
    @Required(percentile95 = 4000)
    public void deleteNewAccount(){
        CreateAccount c = new CreateAccount();
        c.removeOneAccount("thisisaTestAccount2", "thisisaTestPassword!", "testname", "testLastName");
        boolean success = !(c.userNameCheck("thisisaTestAccount2"));
        assertTrue(success);
    }


}