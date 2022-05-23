package ModelPackage1;

import ModelPackage.CreateAccount;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;


@PerfTest(invocations = 10)
@Required(max = 300000, average = 25000)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  // <- Avoids Test Failure due to DB Limitations
public class CreateAccountTest {

    @Rule
    public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());


    //The test should be executed 20 times with no concurrent threads.
    //In addition, a maximum execution time of 2.5 seconds and an average below or equals 2500 milliseconds are tolerated
    @Test
    @PerfTest(invocations = 1)
    @Required(max = 2500, average = 2500)
    public void A_writeNewAccount() {
        CreateAccount c = new CreateAccount();
        boolean success = c.newAccountVerification("thisisaTestAccount2", "thisisaTestPassword!", "testname", "testLastName");
        System.out.println(success); // If name is repeated, success == False, so only 1 invocation per whole run
        assertTrue(success);
    }

    // Requires that 50% of all executions do not take longer than 45 milliseconds
    //The test should be executed 1000 times with 20 concurrent threads, so each thread does 50 invocations.
    @Test
    @PerfTest(invocations = 1000, threads = 20)
    @Required(median = 450)
    public void B_checkRepeatedUsername(){
        CreateAccount c = new CreateAccount();
        boolean success = c.userNameCheck("Francisco");
        assertTrue(success);
    }

    //Requires that 95% of all executions do not take longer than 4000 milliseconds
    @Test
    @PerfTest(invocations = 10)
    @Required(percentile95 = 4000)
    public void C_deleteNewAccount(){
        CreateAccount c = new CreateAccount();
        c.removeOneAccount("thisisaTestAccount2", "thisisaTestPassword!", "testname", "testLastName");
        assertFalse(c.userNameCheck("thisisaTestAccount2"));
    }


}