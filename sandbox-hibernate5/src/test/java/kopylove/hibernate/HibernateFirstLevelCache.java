//package com.github.ivan.kopylove.persistence.hibernate;
//
//import kopylove.hibernate.HibernateSessionFactory;
//import org.hibernate.Session;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
///// First level cache cannot be turned off
//class HibernateFirstLevelCache
//{
//    @BeforeAll
//    public static void populate()
//    {
//        BookEntity05 book = new BookEntity05();
//        book.setId(4);
//        book.setName("Stephen King - Shining");
//
//        Session session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//
//        session.save(book);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Test
//    void no_db_hit()
//    {
//        Session session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//
//        BookEntity05 book = session.load(BookEntity05.class, 4);
//
//        assertEquals(book.getName(), "Stephen King - Shining");
//
//        book = session.load(BookEntity05.class, 4);
//
//        assertEquals(book.getName(), "Stephen King - Shining");
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Test
//    void evict()
//    {
//        Session session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//
//        BookEntity05 book = session.load(BookEntity05.class, 4);
//
//        assertEquals(book.getName(), "Stephen King - Shining");
//        session.evict(book);
//
//        book = session.load(BookEntity05.class, 4);
//        assertEquals(book.getName(), "Stephen King - Shining");
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Test
//    void clear()
//    {
//        Session session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//
//        BookEntity05 book = session.load(BookEntity05.class, 4);
//
//        assertEquals(book.getName(), "Stephen King - Shining");
//        session.clear();
//
//        book = session.load(BookEntity05.class, 4);
//        assertEquals(book.getName(), "Stephen King - Shining");
//
//        session.getTransaction().commit();
//        session.close();
//    }
//}
