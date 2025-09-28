package kopylove.named.nativequery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/// Minimal JPA example - save and load saved entity.
class JpaSimpleNativeQueryTest extends EntityManagerManual
{
    @BeforeEach
    public void populate()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        BookEntity13 bookEntity = new BookEntity13();
        bookEntity.setId(5001);
        bookEntity.setName("some name");

        entityManager.persist(bookEntity);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void exercise_reverse_engineering_design()
    {
        EntityManager entityManager = super.getEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createNativeQuery("SELECT * FROM BookEntity13;");

        List<Tuple> resultList = query.getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
