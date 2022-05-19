package ModelPackage;

import MongoConnector.MyConnector;
import org.junit.jupiter.api.Test;
import org.databene.contiperf.*;
import ModelPackage.CreateAccount;
import static org.junit.jupiter.api.Assertions.*;
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
class CreateAccountTest {


    //@Rule public ContiPerfRule rule = new ContiPerfRule(new EmptyReportModule());
    //@Rule public ContiPerfRule rule = new ContiPerfRule();

    //The test should be executed 1000 times with 20 concurrent threads, so each thread does 50 invocations.
    //In addition, a maximum execution time of 1.2 seconds and an average below or equals 250 milliseconds are tolerated
    @Test
    @PerfTest(invocations = 1000, threads = 20)
    @Required(max = 1200, average = 250)
    void writeNewAccount() {
        CreateAccount c = new CreateAccount();
        boolean success = c.newAccountVerification("thisisaTestAccount2", "thisisaTestPassword!", "testname", "testLastName");
        assertTrue(success);
    }

    // Requires that 50% of all executions do not take longer than 45 milliseconds
    @Test
    @Required(median = 45)
    void checkRepeatedUsername(){
        CreateAccount c = new CreateAccount();
        boolean success = c.userNameCheck("Francisco");
        assertTrue(success);
    }

    //Requires that 95% of all executions do not take longer than 4000 milliseconds
    @Test
    @Required(percentile95 = 4000)
    void deleteNewAccount(){
        CreateAccount c = new CreateAccount();
        c.removeOneAccount("thisisaTestAccount2", "thisisaTestPassword!", "testname", "testLastName");
        boolean success = !(c.userNameCheck("thisisaTestAccount2"));
        assertTrue(success);
    }



}