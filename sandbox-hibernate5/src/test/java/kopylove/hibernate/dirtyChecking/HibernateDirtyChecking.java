package kopylove.hibernate.dirtyChecking;

import kopylove.hibernate.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HibernateDirtyChecking
{
    private static int ID = 1;

    @BeforeAll
    public static void populate()
    {
        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        BookEntity07 book = new BookEntity07();
        book.setName("Maxim Dorofeev - Inbox Zero");
        book.setId(ID);

        session.persist(book);

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


        BookEntity07 book = session.find(BookEntity07.class, ID);
        book.setName("Fred Brooks - The Mythical Man-Month");
        // what is implicit here?

        session.getTransaction().commit();
        session.close();
    }

    public void verifyDirtyCheckWorks()
    {
        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();

        BookEntity07 book = session.find(BookEntity07.class, ID);
        assertEquals("Fred Brooks - The Mythical Man-Month", book.getName());


        session.getTransaction().commit();
        session.close();
    }
}
