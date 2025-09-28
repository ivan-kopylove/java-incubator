package heap.aedc;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.ivan.kopylove.commons.testing.TestBase;
class CollectionsEmptyListTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Object> objects = Collections.emptyList();
            objects.add("dsa");
        });
    }
}
