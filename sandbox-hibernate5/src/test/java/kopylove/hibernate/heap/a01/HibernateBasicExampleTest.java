package kopylove.hibernate.heap.a01;

import kopylove.hibernate.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// Minimal example with Hibernate session - save and load saved entity
/// Example available at: [...](https://github.com/ivan-kopylove/sandbox-java)
class HibernateBasicExampleTest
{
    @Test
    void what_does_this_example_demonstrate()
    {
        BookEntity06 bookEntity = new BookEntity06();
        bookEntity.setName("Harry Potter");
        bookEntity.setId(0);

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(bookEntity);
        session.getTransaction().commit();
        session.close();

        session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        BookEntity06 entity = session.find(BookEntity06.class, 0);
        assertEquals(entity.getName(), "Harry Potter");
        session.getTransaction().commit();
        session.close();
    }
}
