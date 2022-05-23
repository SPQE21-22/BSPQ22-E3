package ModelPackage1;


import ModelPackage.Recipe;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.junit.*;
import static org.junit.Assert.*;


@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class RecipeTest {
    @Test
    @PerfTest(invocations = 300)
    public void userVerification() {
        Recipe testRecipe = new Recipe("Broccolini");
        assertTrue(testRecipe.getValid());
    }
}
