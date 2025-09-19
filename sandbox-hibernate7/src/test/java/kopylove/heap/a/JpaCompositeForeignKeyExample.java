package kopylove.heap.a;


import jakarta.persistence.EntityManager;
import kopylove.heap.EntityManagerProvider;
import kopylove.heap.dsasdasda.BaseSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

class JpaCompositeForeignKeyExample extends BaseSession
{
    @BeforeAll
    public static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction()
                     .begin();

        UserEntity user = new UserEntity();
        user.setCity("Moscow");
        user.setName("bob");
        user.setSsn(99999999);

        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setKey(0);
        documentEntity.setUser(user);

        entityManager.persist(user);
        entityManager.persist(documentEntity);

        entityManager.getTransaction()
                     .commit();
        entityManager.close();
    }

    @Test
    void foo()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction()
                     .begin();

        DocumentEntity documentEntity = entityManager.find(DocumentEntity.class, 0);

        assertEquals(99999999,
                     documentEntity.getUser()
                                   .getSsn());
        assertEquals("bob",
                     documentEntity.getUser()
                                   .getName());

        entityManager.getTransaction()
                     .commit();
        entityManager.close();
    }
}
