package heap.a7d4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// search engine query with comprehensive examples:
/// closure baeldung
///


/// - closure
import com.github.ivan.kopylove.commons.testing.TestBase;
class ClosureExampleTest extends TestBase
{

    static TextProvider getProvider(int value)
    {

        return new TextProvider()
        {
            @Override
            public int get()
            {
                return value;
            }
        };
    }

    @Test
    void exercise_design_reverse_engineering()
    {
        TextProvider provider = getProvider(15);
        assertEquals(15, provider.get());
    }

    interface TextProvider
    {
        int get();
    }
}
