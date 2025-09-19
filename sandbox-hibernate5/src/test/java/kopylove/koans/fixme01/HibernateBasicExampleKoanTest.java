package kopylove.koans.fixme01;

import kopylove.hibernate.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HibernateBasicExampleKoanTest
{
    @Test
    void what_does_this_example_demonstrate()
    {
        Session session = HibernateSessionFactory.openCustomSession("kopylove.koans.fixme01");

        BookEntity07 bookEntity = new BookEntity07();
        bookEntity.setName("Harry Potter");
        bookEntity.setId(0);

        session.getTransaction().begin();
        session.persist(bookEntity);
        session.getTransaction().commit();
        session.close();

        session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        BookEntity07 entity = session.find(BookEntity07.class, 0);
        assertEquals(entity.getName(), "Harry Potter");
        session.getTransaction().commit();
        session.close();
    }
}
