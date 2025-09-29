package d7d8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class CustomExceptionTranslationTest {

    @Autowired
    private CustomRepository customRepository;

    @Test
    void whenCustomPersistenceExceptionThrown_thenTranslatedUsingCustomTranslator() {
        assertThrows(CustomDataAccessException.class, () -> {
            customRepository.operationWithCustomException();
        });
    }

    @Configuration
    static class TestConfig {

        @Bean
        public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
            PersistenceExceptionTranslationPostProcessor processor = new PersistenceExceptionTranslationPostProcessor();
            return processor;
        }

        @Bean
        public PersistenceExceptionTranslator customPersistenceExceptionTranslator() {
            return new CustomPersistenceExceptionTranslator();
        }

        @Bean
        public CustomRepository customRepository() {
            return new CustomRepository();
        }
    }

    static class CustomPersistenceExceptionTranslator implements PersistenceExceptionTranslator {
        @Override
        public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
            if (ex instanceof CustomPersistenceException) {
                return new CustomDataAccessException("Translated: " + ex.getMessage(), ex);
            }
            return null;
        }
    }

    @Repository
    static class CustomRepository {
        public void operationWithCustomException() {
            throw new CustomPersistenceException("Custom persistence error");
        }
    }

    static class CustomPersistenceException extends RuntimeException {
        public CustomPersistenceException(String message) {
            super(message);
        }
    }

    static class CustomDataAccessException extends DataAccessException {
        public CustomDataAccessException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}