package ae01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.orm.jpa.hibernate.HibernateExceptionTranslator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"ae01"})
class Configs
{
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    CustomPersistenceExceptionTranslator customPersistenceExceptionTranslator(){
        return new CustomPersistenceExceptionTranslator();
    }

    @Bean
    HibernateExceptionTranslator hibernateExceptionTranslator(){
        return new HibernateExceptionTranslator();
    }

    static class CustomPersistenceExceptionTranslator implements PersistenceExceptionTranslator
    {
        @Override
        public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
            if (ex instanceof CustomPersistenceException) {
                return new CustomDataAccessException("Translated: " + ex.getMessage(), ex);
            }
            return null;
        }
    }

    static class CustomPersistenceException extends RuntimeException {
        CustomPersistenceException(String message) {
            super(message);
        }
    }

    static class CustomDataAccessException extends DataAccessException {
        CustomDataAccessException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}

