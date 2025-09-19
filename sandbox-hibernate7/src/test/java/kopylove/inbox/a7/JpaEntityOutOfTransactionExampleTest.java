//package com.github.ivan.kopylove.persistence.jpa;
//
//
//import com.github.ivan.kopylove.persistence.jpa.a7.BookEntity3;
//import com.github.ivan.kopylove.persistence.jpa.a7.PageEntity3;
//
//import org.hibernate.LazyInitializationException;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class JpaEntityOutOfTransactionExampleTest
//{
//    private static int pageId;
//
//    @BeforeAll
//    public static void populate()
//    {
//        EntityManager entityManager = EntityManagerProvider.getEntityManager();
//        entityManager.getTransaction()
//                     .begin();
//
//        BookEntity3 book = new BookEntity3();
//        book.setId(7);
//        book.setName("The Lord of the Rings");
//
//        PageEntity3 page = new PageEntity3();
//        page.setAnnotations("1. Annotation; 2. Annotation");
//        page.setName("");
//        page.setBook(book);
//
//        entityManager.persist(book);
//        entityManager.persist(page);
//
//        pageId = page.getKey();
//
//        entityManager.getTransaction()
//                     .commit();
//        entityManager.close();
//    }
//
//    @Test
//    void normalBehaviour()
//    {
//        EntityManager entityManager = EntityManagerProvider.getEntityManager();
//        entityManager.getTransaction()
//                     .begin();
//
//        PageEntity3 page = entityManager.find(PageEntity3.class, pageId);
//        assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page.getAnnotations());
//        assertEquals("asserts book name equality", page.getName(), "");
//
//        entityManager.getTransaction()
//                     .commit();
//        entityManager.close();
//    }
//
//    @Test
//    void outOfTransactionNoFkNoGetter()
//    {
//        assertThrows(LazyInitializationException.class, () -> {
//
//
//            EntityManager entityManager = EntityManagerProvider.getEntityManager();
//            entityManager.getTransaction()
//                         .begin();
//
//            PageEntity3 page = entityManager.find(PageEntity3.class, pageId);
//
//            assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page.getAnnotations());
//            assertEquals("asserts book name equality", page.getName(), "");
//
//            entityManager.getTransaction()
//                         .commit();
//            entityManager.close();
//
//            BookEntity3 book = page.getBook();
//
//            book.getName();
//        });
//    }
//
//    @Test
//    void outOfTransactionNoFkGet()
//    {
//        EntityManager entityManager = EntityManagerProvider.getEntityManager();
//        entityManager.getTransaction()
//                     .begin();
//
//        PageEntity3 page = entityManager.find(PageEntity3.class, pageId);
//
//        entityManager.getTransaction()
//                     .commit();
//        entityManager.close();
//
//        assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page.getAnnotations());
//        assertEquals("asserts book name equality", page.getName(), "");
//
//        BookEntity3 book = page.getBook();
//    }
//}
