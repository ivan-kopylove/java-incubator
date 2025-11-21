package c6f4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class PropertiesConfigRecordClassTest
{
    @Autowired
    private MyRecordClassProperties myRecordClassProperties;

    @Test
    void exercise_design_reverse_engineering()
    {
        assertThat(myRecordClassProperties.myName(), equalTo("MyName10"));
        assertThat(myRecordClassProperties.yourName(), equalTo("YourName11"));
    }
}
