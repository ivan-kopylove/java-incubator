package dbf2;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static dbf2.MySchedulableService.FIXED_DELAY;
import static dbf2.MySchedulableService.FIXED_RATE;
import static dbf2.MySchedulableService2.FIXED_RATE_ASYNC;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
class Tests extends TestBase
{
    @Autowired
    private MySchedulableService myTransactionalService;

    @Test
    void what_will_be_printed1() throws InterruptedException
    {
        Thread.sleep(30000);

        System.out.println("FIXED_DELAY: " + FIXED_DELAY);
        System.out.println("FIXED_RATE: " + FIXED_RATE);
        System.out.println("FIXED_RATE_ASYNC: " + FIXED_RATE_ASYNC);
    }
}



