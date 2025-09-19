//package kopylove.hibernate.heap.a04;
//
//import kopylove.hibernate.HibernateSessionFactory;
//import kopylove.hibernate.heap.a04.ParentEntity15;
//import org.hibernate.Session;
//import org.hibernate.TransientPropertyValueException;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
/// // This example demonstrates exception when saving child before parent
//class SaveChildBeforeParentTest
//{
//    @Test
//    void saveChildBeforeParent()
//    {
//        assertThrows(TransientPropertyValueException.class, () -> {
//            Session session = HibernateSessionFactory.openSession();
//            session.getTransaction().begin();
//
//            ParentEntity15 ParentEntity15 = new ParentEntity15();
//            ParentEntity15.setId(10);
//            ParentEntity15.setName("123");
//
//            ChildEntity15 childEntity15 = new ChildEntity15();
//            childEntity15 = new ChildEntity15();
//            childEntity15.setKey(10);
//            childEntity15.setName("123");
//            childEntity15.setParent(ParentEntity15);
//
//
//            session.saveOrUpdate(ChildEntity15);
//            session.saveOrUpdate(ParentEntity15);
//            session.getTransaction().commit();
//
//            session.close();
//        });
//    }
//}
