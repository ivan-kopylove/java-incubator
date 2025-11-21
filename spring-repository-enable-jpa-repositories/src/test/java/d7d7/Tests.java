package d7d7;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Configs.class)
class Tests extends TestBase
{
    @Autowired
    private PersonRepository service;

    @Test
    void exercise_design_reverse_engineering()
    {
        service.findById(1);
    }
}