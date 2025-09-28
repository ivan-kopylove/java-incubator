package heap.a3c5;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClonableExamplesTest extends TestBase
{
    @Test
    void not_clonable()
    {
        assertThrows(CloneNotSupportedException.class, () -> {

            MyNotClonableObj original = new MyNotClonableObj();
            original.get();
        });
    }

    @Test
    void clonable() throws CloneNotSupportedException
    {
        MyClonableObj original = new MyClonableObj();

        MyClonableObj cloned = (MyClonableObj) original.get();
        assertNotSame(original, cloned);
        assertEquals(cloned.getField(), original.getField());
    }
}
