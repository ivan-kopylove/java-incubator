package ae01;

import ae01.Configs.CustomDataAccessException;
import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Configs.class)
class Tests extends TestBase
{
    @Autowired
    private MyRepo repo;

    @Test
    void exercise_design_reverse_engineering1() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            repo.foo1();
        });
    }

    @Test
    void exercise_design_reverse_engineering2() {
        assertThrows(CustomDataAccessException.class, () -> {
            repo.foo2();
        });
    }


    @Test
    void exercise_design_reverse_engineering3() {
        assertThrows(InvalidDataAccessApiUsageException.class, () -> {
            repo.foo3();
        });
    }



    @Test
    void exercise_design_reverse_engineering4() {
        assertThrows(NullPointerException.class, () -> {
            repo.foo4();
        });
    }






}