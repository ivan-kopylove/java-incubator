package kopylove.heap.c3d7;

import jakarta.persistence.EntityManager;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import heap.qweqweweqweq.TestBase;
class JpaSharedGeneratedValueTest extends TestBase extends EntityManagerManual
{
    @Test
    void exercise_design_reverse_engineering()
    {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        GeneratedValue02 g10 = new GeneratedValue02();
        GeneratedValue02 g11 = new GeneratedValue02();
        GeneratedValueSecond02 g20 = new GeneratedValueSecond02();

        entityManager.persist(g10);
        entityManager.persist(g11);

        entityManager.persist(g20);

        assertEquals(1, g10.getId());
        assertEquals(1, g20.getId());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
