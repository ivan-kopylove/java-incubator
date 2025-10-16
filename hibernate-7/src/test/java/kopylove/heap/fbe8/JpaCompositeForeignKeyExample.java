package kopylove.heap.fbe8;

import jakarta.persistence.EntityManager;
import kopylove.heap.b505.EntityManagerProvider;
import kopylove.heap.e70a.EntityManagerTransactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JpaCompositeForeignKeyExample extends EntityManagerTransactional
{
    @BeforeAll
    static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        UserEntity02 user = new UserEntity02();
        user.setCity("Moscow");
        user.setName("bob");
        user.setSsn(99999999);

        DocumentEntity01 documentEntity = new DocumentEntity01();
        documentEntity.setKey(0);
        documentEntity.setUser(user);

        entityManager.persist(user);
        entityManager.persist(documentEntity);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void exercise_design_reverse_engineering()
    {
        EntityManager entityManager = super.getEntityManager();

        DocumentEntity01 documentEntity = entityManager.find(DocumentEntity01.class, 0);

        assertEquals(99999999, documentEntity.getUser().getSsn());
        assertEquals("bob", documentEntity.getUser().getName());
    }
}
