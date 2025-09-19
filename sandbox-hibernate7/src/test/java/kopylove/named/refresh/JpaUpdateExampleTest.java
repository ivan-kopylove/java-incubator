package kopylove.named.refresh;



import kopylove.heap.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import kopylove.heap.dsasdasda.BaseSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

/// Example of EntityManager#refresh.
class JpaUpdateExampleTest extends BaseSession
{
    @BeforeAll
    public static void prepareData()
    {
        ParentEntityRefresh parentEntity = new ParentEntityRefresh();
        parentEntity.setId(101);
        parentEntity.setName("Robert Patrick");

        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction()
                     .begin();
        entityManager.persist(parentEntity);
        entityManager.getTransaction()
                     .commit();
    }

    @Test
    void what_does_this_example_demonstrate()
    {
        EntityManager entityManger = EntityManagerProvider.getEntityManager();
        ParentEntityRefresh parentEntity = entityManger.find(ParentEntityRefresh.class, 101);
        parentEntity.setName("Linda Hamilton");

        parentEntity = entityManger.find(ParentEntityRefresh.class,
                                         101); //loads from persistence context first, then from database

        assertEquals("Linda Hamilton", parentEntity.getName());

        entityManger.refresh(parentEntity); //forces to update entity from database

        assertEquals("Robert Patrick", parentEntity.getName());
    }
}
