package a8a9;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config01.class)
 class Config01Test
{
    private ApplicationContext applicationContext;
    private String myString;

    Config01Test(@Autowired ApplicationContext applicationContext, @Autowired String myString)
    {
        this.applicationContext = applicationContext;
        this.myString = myString;
    }


    @Test
    void exercise_design_reverse_engineering() {
        String message = applicationContext.getBean(String.class);
        assertThat(message, equalTo("Hello from Config01"));
    }

    @Test
    void exercise_design_reverse_engineering2() {
        assertThat(myString, equalTo("Hello from Config01"));
    }
}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config02.class)
 class Config02Test
{

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void exercise_design_reverse_engineering() {
        String message = applicationContext.getBean(String.class);

        assertThat(message, equalTo("Hello from Config02"));
    }
}