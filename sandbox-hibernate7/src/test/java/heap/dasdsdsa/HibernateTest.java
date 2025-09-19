package heap.dasdsdsa;

import heap.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HibernateTest {

    private EntityManager entityManager;

    @BeforeEach
    void setUp()
    {
        entityManager = EntityManagerProvider.getEntityManager();
    }


    
    @Test
    void testPackageScan() {
        
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