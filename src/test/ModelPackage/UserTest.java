package ModelPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
//Executes the test 300 times, regardless of the number of threads.
    @Test
    @PerfTest(invocations = 300)
    void userVerification() {
        User testUser = new User("Francisco","123456789");
        assertTrue(testUser.getValid());
    }
}