//package com.github.ivan.kopylove.persistence.jpa;
//
//
//import com.github.ivan.kopylove.persistence.jpa.a7.BookEntity03;
//import com.github.ivan.kopylove.persistence.jpa.a7.PageEntity03;
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
//
class JpaEntityOutOfTransactionExampleTest 
//{
//    private static int pageId;
//
//    @BeforeAll
//    public static void populate()
//    {
//        EntityManager entityManager = super.getEntityManager();
//        entityManager.getTransaction()
//                     .begin();
//
//        BookEntity03 book = new BookEntity03();
//        book.setId(7);
//        book.setName("The Lord of the Rings");
//
//        PageEntity03 page = new PageEntity03();
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
//        EntityManager entityManager = super.getEntityManager();
//        entityManager.getTransaction()
//                     .begin();
//
//        PageEntity03 page = entityManager.find(PageEntity03.class, pageId);
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
//            EntityManager entityManager = super.getEntityManager();
//            entityManager.getTransaction()
//                         .begin();
//
//            PageEntity03 page = entityManager.find(PageEntity03.class, pageId);
//
//            assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page.getAnnotations());
//            assertEquals("asserts book name equality", page.getName(), "");
//
//            entityManager.getTransaction()
//                         .commit();
//            entityManager.close();
//
//            BookEntity03 book = page.getBook();
//
//            book.getName();
//        });
//    }
//
//    @Test
//    void outOfTransactionNoFkGet()
//    {
//        EntityManager entityManager = super.getEntityManager();
//        entityManager.getTransaction()
//                     .begin();
//
//        PageEntity03 page = entityManager.find(PageEntity03.class, pageId);
//
//        entityManager.getTransaction()
//                     .commit();
//        entityManager.close();
//
//        assertEquals("asserts pk equality", "1. Annotation; 2. Annotation", page.getAnnotations());
//        assertEquals("asserts book name equality", page.getName(), "");
//
//        BookEntity03 book = page.getBook();
//    }
//}
