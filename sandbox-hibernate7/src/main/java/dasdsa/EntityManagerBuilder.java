package dasdsa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EntityManagerBuilder
{
    private static EntityManagerFactory emf;
    private static EntityManager        em;

    public static void close()
    {
        em.close();
        emf.close();
    }

    public static EntityManager getEntityManager(List<Class<?>> classes)
    {
        if (em == null)
        {
            em = build(classes);
        }
        return em;
    }

    private static EntityManager build(List<Class<?>> annotatedClass)
    {
        Configuration configuration = new Configuration();

        // Database connection settings
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");

        // Hibernate specific properties
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        // SQL logging
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "false");
        configuration.setProperty("hibernate.use_sql_comments", "true");

//        configuration.addPackage("com.example");

        annotatedClass.forEach(clazz -> {
            configuration.addAnnotatedClass(clazz);
        });


        // Build EntityManagerFactory
        emf = configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        return emf.createEntityManager();
    }
}
