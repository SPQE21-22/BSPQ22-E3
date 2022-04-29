package ModelPackage;

import MongoConnector.MyConnector;
import org.junit.jupiter.api.Test;
import ModelPackage.CreateAccount;
import static org.junit.jupiter.api.Assertions.*;

class CreateAccountTest {



    @Test
    void writeNewAccount() {
        CreateAccount c = new CreateAccount();
        boolean success = c.newAccountVerification("thisisaTestAccount2", "thisisaTestPassword!", "testname", "testLastName");
        assertTrue(success);
    }
    @Test
    void checkRepeatedUsername(){
        CreateAccount c = new CreateAccount();
        boolean success = c.userNameCheck("Francisco");
        assertTrue(success);
    }

    @Test
    void deleteNewAccount(){
        CreateAccount c = new CreateAccount();
        c.removeOneAccount("thisisaTestAccount2", "thisisaTestPassword!", "testname", "testLastName");
        boolean success = !(c.userNameCheck("thisisaTestAccount2"));
        assertTrue(success);
    }



}