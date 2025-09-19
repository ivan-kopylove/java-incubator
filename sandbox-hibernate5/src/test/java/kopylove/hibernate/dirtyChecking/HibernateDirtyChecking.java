package kopylove.hibernate.dirtyChecking;

import kopylove.hibernate.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HibernateDirtyChecking
{

    @BeforeAll
    public static void populate()
    {
        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        BookEntity06 book = new BookEntity06();
        book.setName("Maxim Dorofeev - Inbox Zero");
        book.setId(1);

        session.persist(book);

        session.getTransaction().commit();
        session.close();
    }

    public static void verifyDirtyCheckWorks()
    {
        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        BookEntity06 book = session.find(BookEntity06.class, 1);
        if (book != null)
        {
            assertEquals("Fred Brooks - The Mythical Man-Month", book.getName());
        }

        session.getTransaction().commit();
        session.close();
    }

    @Test
    void dirtyChecking()
    {
        triggerDirtyCheck();
        verifyDirtyCheckWorks();
    }

    public void triggerDirtyCheck()
    {
        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        BookEntity06 book = session.find(BookEntity06.class, 1);
        if (book != null)
        {
            book.setName("Fred Brooks - The Mythical Man-Month");
            // what is implicit here?
        }

        session.getTransaction().commit();
        session.close();
    }
}
