package com.github.ivan.kopylove.persistence.hibernate;



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
        BookEntity05 bookEntity = new BookEntity05();
        bookEntity.setName("Harry Potter");
        bookEntity.setId(0);

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction()
               .begin();
        session.persist(bookEntity);
        session.getTransaction()
               .commit();
        session.close();

        session = HibernateSessionFactory.openSession();
        session.getTransaction()
               .begin();
        BookEntity05 entity = session.find(BookEntity05.class, 0);
        assertEquals(entity.getName(), "Harry Potter");
        session.getTransaction()
               .commit();
        session.close();
    }
}
