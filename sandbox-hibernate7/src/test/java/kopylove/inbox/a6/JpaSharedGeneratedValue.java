package kopylove.inbox.a6;

import jakarta.persistence.EntityManager;
import kopylove.heap.EntityManagerProvider;
import kopylove.heap.dsasdasda.EntitiManagerSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JpaSharedGeneratedValue extends EntitiManagerSession
{
    @Test
    void what_does_this_example_demonstrate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        GeneratedValue02 g1 = new GeneratedValue02();
        entityManager.persist(g1);

        GeneratedValueSecond02 g2 = new GeneratedValueSecond02();
        entityManager.persist(g2);

        assertEquals(1, g1.getId());
        assertEquals(2, g2.getId());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
