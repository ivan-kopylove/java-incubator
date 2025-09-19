package com.github.ivan.kopylove.persistence.hibernate;


import com.github.ivan.kopylove.sandbox.persistence.util.MetadataExtractorIntegrator;
import org.hibernate.mapping.PersistentClass;
import org.junit.jupiter.api.Test;

class HibernateSpiIntegratorExample
{
    @Test
    void foo()
    {
        EntityManagerProvider.getEntityManager();

        MetadataExtractorIntegrator instance = MetadataExtractorIntegrator.INSTANCE;
        for (PersistentClass clazz : instance.getMetadata()
                                             .getEntityBindings())
        {
            System.out.println(clazz);
        }
    }
}
