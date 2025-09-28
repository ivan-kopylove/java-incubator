package heap.aedc;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CollectionsEmptyListTest
{
    @Test
    void exercise_reverse_engineering_design()
    {
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Object> objects = Collections.emptyList();
            objects.add("dsa");
        });
    }
}
