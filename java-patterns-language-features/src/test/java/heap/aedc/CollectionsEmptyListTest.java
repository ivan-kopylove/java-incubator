package heap.aedc;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CollectionsEmptyListTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Object> objects = Collections.emptyList();
            objects.add("IsolationLevelAnalogy10");
        });
    }
}
