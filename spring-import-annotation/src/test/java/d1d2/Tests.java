package d1d2;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(Configs.class)
class Tests extends TestBase
{
    @Autowired
    private String someBean;

    @Test
    void exercise_design_reverse_engineering()
    {
        System.out.println(someBean);
    }
}