package bf98;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@Import(PropertiesConfig.class)
public class PropertiesConfigTest02
{
    @Autowired
    private MyProperties02 myProperties02;

    @Test
     void exercise_design_reverse_engineering()  {
        assertThat(myProperties02.getMyName(), equalTo("MyName5"));
        assertThat(myProperties02.getYourName(), equalTo("YourName6"));

    }
}
