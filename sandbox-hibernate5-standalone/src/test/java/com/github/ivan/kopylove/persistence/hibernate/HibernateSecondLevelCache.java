//package com.github.ivan.kopylove.persistence.hibernate;
//
//
//
//import org.hibernate.Session;
//import org.hibernate.query.NativeQuery;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class HibernateSecondLevelCache
//{
//    @BeforeAll
//    public static void populate()
//    {
//
//        Session session = HibernateSessionFactory.openSession();
//        session.getTransaction()
//               .begin();
//
//        NativeQuery sqlQuery = session.createSQLQuery("INSERT INTO BOOK VALUES (5, 'Tolkien - The Hobbit')");
//        int i = sqlQuery.executeUpdate();
//        assertEquals(1, i);
//        session.getTransaction()
//               .commit();
//
//        session.close();
//    }
//
//    @Test
//    void foo()
//    {
//        Session session1 = HibernateSessionFactory.openSession();
//        Session session2 = HibernateSessionFactory.openSession();
//        session1.getTransaction()
//                .begin();
//        session2.getTransaction()
//                .begin();
//
//        BookEntity05 book = session1.load(BookEntity05.class, 5);
//        assertEquals(book.getName(), "Tolkien - The Hobbit");
//
//        book = session2.load(BookEntity05.class, 5);
//        assertEquals(book.getName(), "Tolkien - The Hobbit");
//
//        session1.getTransaction()
//                .commit();
//        session2.getTransaction()
//                .commit();
//        session1.close();
//        session2.close();
//    }
//}
