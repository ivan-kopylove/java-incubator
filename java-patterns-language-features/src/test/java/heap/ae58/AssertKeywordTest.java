package heap.ae58;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.ivan.kopylove.commons.testing.TestBase;
class AssertKeywordTest extends TestBase
{
    @Test
    void should_throw_assertion_error()
    {
        assertThrows(AssertionError.class, () -> {
            assert 2 == 1;
        });
    }
}
