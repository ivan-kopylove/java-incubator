package kopylove.hibernate;

import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static com.github.ivan.kopylove.commons.reflection.AnnotatedClassesProvider.getAnnotatedClasses;

public final class HibernateSessionFactory
{
    private static final SessionFactory sessionFactory = buildSessionFactory("kopylove.hibernate");

    private HibernateSessionFactory()
    {
    }

    private static SessionFactory buildSessionFactory(String packageToScan)
    {
        Configuration configuration = new Configuration();

        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");

        configuration.setProperty("hibernate.dialect1", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.format_sql", "false");
        configuration.setProperty("hibernate.use_sql_comments", "false");

        getAnnotatedClasses(Entity.class, packageToScan).forEach(entity -> {
            configuration.addAnnotatedClass(entity);
        });


        return configuration.configure().buildSessionFactory(); // looks for hibernate.cfg.xml
    }

    public static Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public static Session openSession()
    {
        return sessionFactory.openSession();
    }

    public static void close()
    {
        sessionFactory.close();
    }
}
