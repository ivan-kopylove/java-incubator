package heap.a98b;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.ivan.kopylove.commons.testing.TestBase;
class DateExamplesTest extends TestBase
{
    /// Date#before method exists in JCL.
    @Test
    void exercise_design_reverse_engineering()
    {
        Date date = new Date(1561165200000L); //Saturday, June 22, 2019 4:00:00 AM GMT+03:00
        Date date2 = new Date(1529629200000L); //Friday, June 22, 2018 4:00:00 AM GMT+03:00
        assertTrue(date2.before(date));
    }
}