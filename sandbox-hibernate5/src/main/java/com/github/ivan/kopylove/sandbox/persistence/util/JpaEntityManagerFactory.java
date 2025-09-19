package com.github.ivan.kopylove.sandbox.persistence.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.jpa.boot.spi.IntegratorProvider;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class JpaEntityManagerFactory
{
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private JpaEntityManagerFactory()
    {
    }

    private static EntityManagerFactory buildEntityManagerFactory()
    {


        Map<String, Object> configuration = new HashMap<>();

        Integrator integrator = MetadataExtractorIntegrator.INSTANCE;
        if (integrator != null)
        {
            configuration.put("hibernate.integrator_provider",
                              (IntegratorProvider) () -> Collections.singletonList(MetadataExtractorIntegrator.INSTANCE));
        }

        return Persistence.createEntityManagerFactory("my-persistence-unit",
                                                      configuration); // searches for any META-INF/persistence.xml files
    }

    public static EntityManager getEntityManger()
    {
        return emf.createEntityManager();
    }

    /// drops the database when hbm2ddl = create-drop
    public static void closeFactory()
    {
        emf.close();
    }
}
