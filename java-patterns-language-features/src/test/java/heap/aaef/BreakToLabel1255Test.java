package heap.aaef;

import org.junit.jupiter.api.Test;

/// Labels example
/// facets
/// - enthuware
///
/// enthuware.ocpjp.i.v11.2.1255
import com.github.ivan.kopylove.commons.testing.TestBase;
class BreakToLabel1255Test extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        int i = 0;
        loop:
        // 1
        {
            System.out.println("Loop Lable line");
            try
            {
                for (; true; i++)
                {
                    if (i > 5)
                    {
                        break loop;       // 2
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Exception in loop.");
            }
            finally
            {
                System.out.println("In Finally");      // 3
            }
        }
    }
}
