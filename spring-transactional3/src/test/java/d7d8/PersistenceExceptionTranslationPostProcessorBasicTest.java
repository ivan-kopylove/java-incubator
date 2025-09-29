package d7d8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class PersistenceExceptionTranslationPostProcessorBasicTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TestRepository testRepository;

    @Test
    void contextLoads() {
        assertNotNull(applicationContext);
        assertNotNull(testRepository);
    }

    @Test
    void persistenceExceptionTranslationPostProcessorBeanExists() {
        PersistenceExceptionTranslationPostProcessor processor = applicationContext.getBean(PersistenceExceptionTranslationPostProcessor.class);
        assertNotNull(processor);
    }

    @Configuration
    static class TestConfig {

        @Bean
        public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
            return new PersistenceExceptionTranslationPostProcessor();
        }

        @Bean
        public TestRepository testRepository() {
            return new TestRepository();
        }
    }

    @Repository
    static class TestRepository {
        public String someMethod() {
            return "test";
        }
    }
}