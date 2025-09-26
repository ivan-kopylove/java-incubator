package kopylove.named.refresh;

import jakarta.persistence.EntityManager;
import kopylove.heap.b505.EntityManagerProvider;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// Example of EntityManager#refresh.
class JpaUpdateExampleTest extends EntityManagerManual
{
    @BeforeAll
    public static void populate()
    {
        ParentEntity12 parentEntity = new ParentEntity12();
        parentEntity.setId(101);
        parentEntity.setName("Robert Patrick");

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(parentEntity);
        entityManager.getTransaction().commit();
    }

    @Test
    void reverse_engineer_hypothetical_design()
    {
        EntityManager entityManger = super.getEntityManager();
        ParentEntity12 parentEntity = entityManger.find(ParentEntity12.class, 101);
        parentEntity.setName("Linda Hamilton");

        parentEntity = entityManger.find(ParentEntity12.class,
                                         101); //loads from persistence context first, then from database

        assertEquals("Linda Hamilton", parentEntity.getName());

        entityManger.refresh(parentEntity); //forces to update entity from database

        assertEquals("Robert Patrick", parentEntity.getName());
    }
}
