package com.github.ivan.kopylove.persistence.jpa.a6;



import com.github.ivan.kopylove.sandbox.persistence.util.JpaEntityManagerFactory;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JpaSharedGeneratedValue
{
    @Test
    void foo()
    {
        EntityManager entityManager = JpaEntityManagerFactory.getEntityManger();
        entityManager.getTransaction()
                     .begin();

        GeneratedValueMostBasic g1 = new GeneratedValueMostBasic();
        entityManager.persist(g1);

        GeneratedValueMostBasicSecond g2 = new GeneratedValueMostBasicSecond();
        entityManager.persist(g2);

        assertEquals(1, g1.getKey());
        assertEquals(2, g2.getKey());

        entityManager.getTransaction()
                     .commit();
        entityManager.close();
    }
}
