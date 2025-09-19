package kopylove.named.flushmode;



import jakarta.persistence.EntityManager;
import kopylove.heap.EntityManagerProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.FlushModeType;

/// JPA allows implementations to synchronize the persistence context at other times, if they wish.
class JpaFlushMode
{

    @BeforeAll
    public static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        ParentEntity4 parent = new ParentEntity4();
        parent.setName("some name");
        parent.setId(4000);

        entityManager.persist(parent);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void commitMode()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        ParentEntity4 parent = entityManager.find(ParentEntity4.class, 4000);
        parent.setName("new name");

        entityManager.setFlushMode(FlushModeType.COMMIT);

        entityManager.getTransaction().commit();// hibernate does flush
        entityManager.close();
    }
}
