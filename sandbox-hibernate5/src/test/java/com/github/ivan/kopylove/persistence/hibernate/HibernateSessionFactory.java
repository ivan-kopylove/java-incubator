package com.github.ivan.kopylove.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateSessionFactory
{
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateSessionFactory()
    {
    }

    private static SessionFactory buildSessionFactory()
    {
        Configuration configuration = new Configuration();
        configuration.addPackage("com.github.ivan.kopylove");


        configuration.addAnnotatedClasses()


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
