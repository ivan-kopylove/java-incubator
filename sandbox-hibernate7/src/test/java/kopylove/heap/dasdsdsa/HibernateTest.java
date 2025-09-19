package kopylove.heap.dasdsdsa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kopylove.heap.EntityManagerProvider;
import kopylove.heap.dsasdasda.BaseSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HibernateTest extends BaseSession
{
    @Test
    void testPackageScan()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        BookEntity04 book = new BookEntity04();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        entityManager.persist(book);
        entityManager.flush();
        entityManager.clear();

        BookEntity04 found = entityManager.find(BookEntity04.class, book.getId());
        assertEquals("The Hitchhiker's Guide to the Galaxy", found.getTitle());

        tx.commit();
    }
}