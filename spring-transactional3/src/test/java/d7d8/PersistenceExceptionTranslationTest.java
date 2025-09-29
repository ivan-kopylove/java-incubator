package d7d8;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class PersistenceExceptionTranslationTest {

    @Autowired
    private ProblematicRepository problematicRepository;

    @Test
    void whenJpaExceptionThrown_thenTranslatedToDataAccessException() {
        // JPA exceptions should be translated to Spring's DataAccessException
        assertThrows(DataAccessException.class, () -> {
            problematicRepository.throwJpaException();
        });
    }

    @Test
    void whenNonJpaExceptionThrown_thenNotTranslated() {
        // Regular runtime exceptions should not be translated
        assertThrows(IllegalArgumentException.class, () -> {
            problematicRepository.throwNonJpaException();
        });
    }

    @Configuration
    static class TestConfig {

        @Bean
        public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
            return new PersistenceExceptionTranslationPostProcessor();
        }

        @Bean
        public ProblematicRepository problematicRepository() {
            return new ProblematicRepository();
        }
    }

    @Repository
    static class ProblematicRepository {
        
        public void throwJpaException() {
            // Simulate a JPA exception
            throw new EntityNotFoundException("JPA entity not found");
        }

        public void throwNonJpaException() {
            throw new IllegalArgumentException("Regular exception");
        }
    }
}