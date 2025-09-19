//package com.github.ivan.kopylove.persistence.hibernate;
//
//import org.hibernate.Session;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
///// org.hibernate.Criteria simpliest example.
///// Example available at: [...](https://github.com/ivan-kopylove/sandbox-java)
//class HibernateCriteriaExample
//{
//    @BeforeAll
//    public static void populate()
//    {
//        BookEntity05 book = new BookEntity05();
//        book.setId(2);
//        book.setName("The Lord of the Rings");
//
//        Session session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//        session.save(book);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Test
//    void what_does_this_example_demonstrate()
//    {
//        Session session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//
//        Criteria criteria = session.createCriteria(BookEntity05.class);
//        criteria.add(Restrictions.eq("name", "The Lord of the Rings"));
//        List<BookEntity05> list = criteria.list();
//
//        assertTrue(list.size() > 0);
//        assertEquals("The Lord of the Rings", list.get(0).getName());
//
//        session.getTransaction().commit();
//        session.close();
//    }
//}
