package kopylove.inbox.a6;

import jakarta.persistence.EntityManager;
import kopylove.heap.EntityManagerProvider;
import kopylove.heap.dsasdasda.BaseSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JpaSharedGeneratedValue extends BaseSession
{
    @Test
    void what_does_this_example_demonstrate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        GeneratedValueMostBasic02 g1 = new GeneratedValueMostBasic02();
        entityManager.persist(g1);

        GeneratedValueMostBasicSecond02 g2 = new GeneratedValueMostBasicSecond02();
        entityManager.persist(g2);

        assertEquals(1, g1.getId());
        assertEquals(2, g2.getId());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
