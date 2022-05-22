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
public class RecipeTest {
    @Test
    @PerfTest(invocations = 300)
    void userVerification() {
        Recipe testRecipe = new Recipe("Broccolini");
        assertTrue(testRecipe.getValid());
    }
}
