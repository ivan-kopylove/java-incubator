package kopylove.heap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import kopylove.heap.jsdkl.EntityClassProvider;
import org.hibernate.cfg.Configuration;

public class EntityManagerProvider
{
    private static EntityManagerFactory emf;
    private static EntityManager        em;
    private static Configuration        configuration;

    public static EntityManager getEntityManager()
    {
        if (em == null || !em.isOpen())
        {
            em = build();
        }
        return em;
    }

    public static void closeEntityManager()
    {
        if (em.isOpen())
        {
            em.close();
        }
    }

    private static EntityManager build()
    {
        if (emf != null)
        {
            return emf.createEntityManager();
        }

        configuration = new Configuration();

        // Database connection settings
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");

        // Hibernate specific properties
        configuration.setProperty("hibernate.dialect1", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        // SQL logging
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "false");
        configuration.setProperty("hibernate.use_sql_comments", "false");

        EntityClassProvider.getEntities().forEach(entity -> {
            configuration.addAnnotatedClass(entity);
        });


        // Build EntityManagerFactory
        emf = configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        return emf.createEntityManager();
    }
}
