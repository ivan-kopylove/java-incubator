package kopylove.inbox.basicexample;

import jakarta.persistence.EntityManager;
import kopylove.heap.EntityManagerProvider;
import kopylove.heap.dsasdasda.BaseSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// Minimal JPA example - save and load saved entity.
class JpaBasicExampleTest extends BaseSession
{
    @Test
    void what_does_this_example_demonstrate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        BookEntity2 bookEntity = new BookEntity2();
        bookEntity.setName("Terry Pratchett - The Colour of Magic");
        bookEntity.setId(6);
        entityManager.persist(bookEntity);

        entityManager.getTransaction().commit();

        BookEntity2 entity = entityManager.find(BookEntity2.class, 6);
        assertEquals(entity.getName(), "Terry Pratchett - The Colour of Magic");
        entityManager.close();
    }
}
