package kopylove.heap.a3;

import jakarta.persistence.EntityManager;
import kopylove.heap.dasads.EntityManagerProvider;
import kopylove.heap.dsasdasda.EntityManagerSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JpaEntityStateAfterFlush extends EntityManagerSession
{
    @BeforeAll
    public static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        ParentEntity11 parent = new ParentEntity11();
        parent.setName("0");
        parent.setId(3000);

        entityManager.persist(parent);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void what_does_this_example_demonstrate()
    {
        do_flush();
        read_again();
    }

    public void do_flush()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        ParentEntity11 parent = entityManager.find(ParentEntity11.class, 3000);
        parent.setName("1");

        entityManager.flush(); //commits accumulated changes to the database

        parent.setName("2");

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void read_again()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        ParentEntity11 parent = entityManager.find(ParentEntity11.class, 3000);

        assertEquals("2", parent.getName());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
