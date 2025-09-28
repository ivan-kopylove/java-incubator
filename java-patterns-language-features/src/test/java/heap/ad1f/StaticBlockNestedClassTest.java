package heap.ad1f;

import org.junit.jupiter.api.Test;

import com.github.ivan.kopylove.commons.testing.TestBase;
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

