package kopylove.heap.a5;

import jakarta.persistence.EntityManager;
import kopylove.heap.dasads.EntityManagerProvider;
import kopylove.heap.dsasdasda.EntityManagerSession;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.proxy.HibernateProxy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/// Difference between EntityManager#find and EntityManager#getReference
class JpaFindvsGetReferenceTest extends EntityManagerSession
{
    @BeforeAll
    public static void populate()
    {
        ParentEntity10 parentEntity = new ParentEntity10();
        parentEntity.setId(0);
        parentEntity.setName("some parent name");

        EntityManager entityManger = EntityManagerProvider.getEntityManager();
        entityManger.getTransaction().begin();
        entityManger.persist(parentEntity);
        entityManger.getTransaction().commit();
        entityManger.close();
    }

    @Test
    void find_method()
    {
        EntityManager entityManger = super.getEntityManager();

        // not a proxy with no lazy access;
        // if the object is not found in the database null is returned
        ParentEntity10 parentEntityObject = entityManger.find(ParentEntity10.class, 0);

        assertFalse(parentEntityObject.getClass().toString().contains("_$$_jvst"));
        entityManger.close();
    }

    /// proxy, that provides lazy access, throws an error on access
    /// getReference is the lazy version of find
    /// The object content is retrieved from the database and the persistent fields are initialized lazily
    @Test
    void getReference()
    {
        EntityManager entityManger = super.getEntityManager();

        ParentEntity10 anEntity = entityManger.getReference(ParentEntity10.class,
                                                            999999999); //no db hit, parent is taken from proxy (what level?)

        assertEquals(999999999, anEntity.getId()); //no init
        assertInstanceOf(HibernateProxy.class, anEntity);
        String string = anEntity.getClass().toString();
        System.out.println(string);

        assertTrue(string.contains("$HibernateProxy"));

        entityManger.close();
    }

    @Test
    void getReferenceException()
    {
        assertThrows(ObjectNotFoundException.class, () -> {
            EntityManager entityManger = super.getEntityManager();

            ParentEntity10 parent = entityManger.getReference(ParentEntity10.class, 999999999); //no db hit

            assertEquals(999999999, parent.getId());//no init
            assertTrue(parent.getClass().toString().contains("$HibernateProxy"));
            assertInstanceOf(HibernateProxy.class, parent);
            parent.getName(); //produces exception

            entityManger.close();
        });
    }
}
