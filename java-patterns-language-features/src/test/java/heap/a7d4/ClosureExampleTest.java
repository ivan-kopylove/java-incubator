package heap.a7d4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// search engine query with comprehensive examples:
/// closure baeldung
///
/// facets:
/// - patterns
/// - closure
class ClosureExampleTest
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
    void reverse_engineer_hypothetical_designTest()
    {
        TextProvider provider = getProvider(15);
        assertEquals(15, provider.get());
    }

    interface TextProvider
    {
        int get();
    }
}
