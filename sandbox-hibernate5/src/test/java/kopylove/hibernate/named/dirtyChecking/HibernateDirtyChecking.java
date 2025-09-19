package kopylove.hibernate.named.dirtyChecking;

import kopylove.hibernate.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        /// what is implicit here?
        /// [kopylove.heap.d3f8.JpaFindvsGetReferenceTest] for insights

        session.getTransaction().commit();
        session.close();
    }
}
