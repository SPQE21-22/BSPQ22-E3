package ModelPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void userVerification() {
        User testUser = new User("Francisco","123456789");
        assertTrue(testUser.getValid());
    }
}