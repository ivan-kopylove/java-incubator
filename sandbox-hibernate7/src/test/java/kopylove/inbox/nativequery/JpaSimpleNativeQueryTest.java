package kopylove.inbox.nativequery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import kopylove.heap.EntityManagerProvider;
import kopylove.heap.dsasdasda.EntityManagerSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/// Minimal JPA example - save and load saved entity.
class JpaSimpleNativeQueryTest extends EntityManagerSession
{
    @BeforeEach
    public void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        BookEntity13 bookEntity = new BookEntity13();
        bookEntity.setId(5001);
        bookEntity.setName("some name");

        entityManager.persist(bookEntity);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void what_does_this_example_demonstrate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM BOOK;");

        List<Tuple> resultList = query.getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
