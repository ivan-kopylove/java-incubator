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
        // Perform test
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Book book = new Book("The Hitchhiker's Guide to the Galaxy");
        entityManager.persist(book);
        entityManager.flush();
        entityManager.clear();

        Book found = entityManager.find(Book.class, book.getId());
        assertEquals("The Hitchhiker's Guide to the Galaxy", found.getTitle());

        tx.commit();
    }
}