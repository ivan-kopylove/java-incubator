//package kopylove.hibernate.heap.a03;
//
//import kopylove.hibernate.HibernateSessionFactory;
//import org.hibernate.Session;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class ReadInTheSameTransaction
//{
//    @Test
//    void test_find()
//    {
//        ParentEntity14 parentEntity = new ParentEntity14();
//        parentEntity.setId(4);
//        parentEntity.setName("test4");
//
//        Session session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//        session.saveOrUpdate(parentEntity);
//        session.getTransaction().commit();
//
//        session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//        ParentEntity14 entity = session.get(ParentEntity14.class, 4);
//        entity.setName("test4-2");
//
//        ParentEntity14 entity2 = session.find(ParentEntity14.class, 4);
//        assertEquals("message", "test4-2", entity2.getName());
//        session.close();
//    }
//
//    @Test
//    void test_get()
//    {
//        ParentEntity14 parentEntity = new ParentEntity14();
//        parentEntity.setId(4);
//        parentEntity.setName("test4");
//
//        Session session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//        session.saveOrUpdate(parentEntity);
//        session.getTransaction().commit();
//
//        session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//        ParentEntity14 entity = session.get(ParentEntity14.class, 4);
//        entity.setName("test4-2");
//
//        ParentEntity14 entity2 = session.get(ParentEntity14.class, 4);
//        assertEquals("message", "test4-2", entity2.getName());
//    }
//
//    @Test
//    void test_load()
//    {
//        ParentEntity14 parentEntity = new ParentEntity14();
//        parentEntity.setId(4);
//        parentEntity.setName("test4");
//
//        Session session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//        session.saveOrUpdate(parentEntity);
//        session.getTransaction().commit();
//
//        session = HibernateSessionFactory.openSession();
//        session.getTransaction().begin();
//        ParentEntity14 entity = session.get(ParentEntity14.class, 4);
//        entity.setName("test4-2");
//
//        ParentEntity14 entity2 = session.load(ParentEntity14.class, 4);
//        assertEquals("message", "test4-2", entity2.getName());
//    }
//}
