package kopylove.named.basic01;

import jakarta.persistence.EntityManager;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// Minimal JPA example - save and load saved entity.
class JpaBasicExampleTest  extends EntityManagerManual
{
    @Test
    void exercise_design_reverse_engineering()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        BookEntity02 bookEntity = new BookEntity02();
        bookEntity.setName("Terry Pratchett - The Colour of Magic");
        bookEntity.setId(6);
        entityManager.persist(bookEntity);

        entityManager.getTransaction().commit();

        BookEntity02 entity = entityManager.find(BookEntity02.class, 6);
        assertEquals(entity.getName(), "Terry Pratchett - The Colour of Magic");
        entityManager.close();
    }
}
