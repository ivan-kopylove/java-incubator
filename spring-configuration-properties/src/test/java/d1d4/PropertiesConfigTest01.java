package d1d4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
class PropertiesConfigTest01
{
    @Autowired
    private MyProperties01 myProperties01;

    @Test
    void exercise_design_reverse_engineering()  {
        assertThat(myProperties01.getMyName(), equalTo("MyName2"));
        assertThat(myProperties01.getYourName(), equalTo("YourName3"));

    }
}
