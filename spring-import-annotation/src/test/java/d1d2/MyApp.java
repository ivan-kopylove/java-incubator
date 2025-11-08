package d1d2;

import org.springframework.boot.autoconfigure.SpringBootApplication;


/// Why this piece of boilerplate is not included into [org.springframework.boot.test.context.SpringBootTest]?
/// Unable to find a @SpringBootConfiguration by searching packages upwards from the test
/// what if I drop this class?
@SpringBootApplication
public class MyApp
{}
