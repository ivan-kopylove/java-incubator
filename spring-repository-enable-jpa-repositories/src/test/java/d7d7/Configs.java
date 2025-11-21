package d7d7;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.hibernate.HibernateExceptionTranslator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static com.github.ivan.kopylove.commons.reflection.AnnotatedClassesProvider.getAnnotatedClasses;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"d7d7"})
@EnableJpaRepositories(basePackages = "d7d7")
class Configs
{
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor()
    {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    //    @Bean
    //    LocalSessionFactoryBean localSessionFactoryBean(){
    //        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
    //
    //        return localSessionFactoryBean;
    //    }

    @Bean
    CustomPersistenceExceptionTranslator customPersistenceExceptionTranslator()
    {
        return new CustomPersistenceExceptionTranslator();
    }

    @Bean
    HibernateExceptionTranslator hibernateExceptionTranslator()
    {
        return new HibernateExceptionTranslator();
    }

    @Bean
    DataSource dataSource()
    {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.h2.Driver");
        config.setJdbcUrl("jdbc:h2:mem:testdb");
        config.setUsername("sa");

        // Optional: Configure connection pool properties
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setConnectionTimeout(30000); // 30 seconds
        config.setIdleTimeout(600000);      // 10 minutes
        config.setMaxLifetime(1800000);     // 30 minutes

        return new HikariDataSource(config);
    }

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory emf)
    {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    EntityManager entityManager(EntityManagerFactory emf)
    {
        return emf.createEntityManager();
    }

    @Bean
    EntityManagerFactory entityManagerFactory()
    {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");

        configuration.setProperty("hibernate.dialect1", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "false");
        configuration.setProperty("hibernate.use_sql_comments", "false");

        getAnnotatedClasses(Entity.class, "d7d7").forEach(entity -> {
            configuration.addAnnotatedClass(entity);
        });

        return configuration.buildSessionFactory()
                            .unwrap(EntityManagerFactory.class);
    }

    static class CustomPersistenceExceptionTranslator implements PersistenceExceptionTranslator
    {
        @Override
        public DataAccessException translateExceptionIfPossible(RuntimeException ex)
        {
            if (ex instanceof CustomPersistenceException)
            {
                return new CustomDataAccessException("Translated: " + ex.getMessage(), ex);
            }
            return null;
        }
    }

    static class CustomPersistenceException extends RuntimeException
    {
        CustomPersistenceException(String message)
        {
            super(message);
        }
    }

    static class CustomDataAccessException extends DataAccessException
    {
        CustomDataAccessException(String message, Throwable cause)
        {
            super(message, cause);
        }
    }
}

