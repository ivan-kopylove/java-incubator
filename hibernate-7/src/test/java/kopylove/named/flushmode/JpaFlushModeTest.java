package kopylove.named.flushmode;

import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import kopylove.heap.b505.EntityManagerProvider;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/// JPA allows implementations to synchronize the persistence context at other times, if they wish.

class JpaFlushModeTest  extends EntityManagerManual
{

    @BeforeAll
    static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        ParentEntity04 parent = new ParentEntity04();
        parent.setName("some name");
        parent.setId(4000);

        entityManager.persist(parent);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void commitMode()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        ParentEntity04 parent = entityManager.find(ParentEntity04.class, 4000);
        parent.setName("new name");

        entityManager.setFlushMode(FlushModeType.COMMIT);

        entityManager.getTransaction().commit();// hibernate does flush
        entityManager.close();
    }
}
