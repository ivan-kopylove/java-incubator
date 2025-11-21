package kopylove.heap.c1977;

import jakarta.persistence.EntityManager;
import kopylove.heap.b505.EntityManagerProvider;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JpaEntityStateAfterFlush extends EntityManagerManual
{
    @BeforeAll
    static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction()
                     .begin();

        ParentEntity11 parent = new ParentEntity11();
        parent.setName("0");
        parent.setId(3000);

        entityManager.persist(parent);

        entityManager.getTransaction()
                     .commit();
        entityManager.close();
    }

    @Test
    void exercise_design_reverse_engineering()
    {
        do_flush();
        read_again();
    }

    void do_flush()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction()
                     .begin();

        ParentEntity11 parent = entityManager.find(ParentEntity11.class, 3000);
        parent.setName("1");

        entityManager.flush(); //commits accumulated changes to the database

        parent.setName("2");

        entityManager.getTransaction()
                     .commit();
        entityManager.close();
    }

    void read_again()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction()
                     .begin();

        ParentEntity11 parent = entityManager.find(ParentEntity11.class, 3000);

        assertEquals("2", parent.getName());

        entityManager.getTransaction()
                     .commit();
        entityManager.close();
    }
}
