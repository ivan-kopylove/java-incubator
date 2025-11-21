package heap.ad1f;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

class StaticBlockNestedClassTest extends TestBase
{

    @Test
    void exercise_design_reverse_engineering()
    {
        System.out.println(Child.ID);
    }

    @Test
    void exercise_design_reverse_engineering2()
    {
        new Child();
    }
}

