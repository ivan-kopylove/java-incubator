package kopylove.heap.cb891;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kopylove.heap.e70a.EntityManagerSession;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HibernateTest extends EntityManagerSession
{
    @Test
    void testPackageScan()
    {
        EntityManager entityManager = super.getEntityManager();

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