package aa01;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TxEnabled.class)
class Test10 extends TestBase
{
    @Autowired
    private MyTransactionalService myTransactionalService;

    @Test
    void exercise_design_reverse_engineering() {
        assertThat(myTransactionalService.getClass().toString(), containsString("class aa01.MyTransactionalService"));
        assertThat(myTransactionalService.getClass().toString(), containsString("$$SpringCGLIB$$"));
    }
}


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TxEnabled.class)
class Test11 extends TestBase
{

    @Autowired
    private MyService myService;

    @Test
    void exercise_design_reverse_engineering() {
        assertThat(myService.getClass().toString(), containsString("class aa01.MyService"));
        assertThat(myService.getClass().toString(), not(containsString("$$SpringCGLIB$$")));
    }
}



@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TxDisabled.class)
class Test20 extends TestBase
{
    @Autowired
    private MyTransactionalService myTransactionalService;

    @Test
     void exercise_design_reverse_engineering() {
        assertThat(myTransactionalService.getClass().toString(), containsString("class aa01.MyTransactionalService"));
        assertThat(myTransactionalService.getClass().toString(), not(containsString("$$SpringCGLIB$$")));
    }


}

