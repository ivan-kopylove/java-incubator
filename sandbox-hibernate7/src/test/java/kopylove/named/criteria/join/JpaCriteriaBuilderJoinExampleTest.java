package kopylove.named.criteria.join;




import kopylove.heap.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;






import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// This example demonstrates minimal join boilerplate
class JpaCriteriaBuilderJoinExampleTest
{
    @BeforeAll
    public static void prepareData()
    {

        ParentEntity2 parentEntity = new ParentEntity2();
        parentEntity.setId(100);
        parentEntity.setName("some parent name");

        ChildEntity2 childEntity = new ChildEntity2();
        childEntity.setKey(100);
        childEntity.setName("some child name");
        childEntity.setParent(parentEntity);

        EntityManager entityManager = EntityManagerProvider.getEntityManager();

        entityManager.getTransaction()
                     .begin();

        entityManager.persist(parentEntity);
        entityManager.persist(childEntity);

        entityManager.getTransaction()
                     .commit();
    }

    @Test
    void what_does_this_example_demonstrate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity2> cq = cb.createQuery(ParentEntity2.class);//result
        Root<ParentEntity2> root = cq.from(ParentEntity2.class);//to start from

        root.join("childs");
        cq.select(root);

        TypedQuery<ParentEntity2> query = entityManager.createQuery(cq);
        List<ParentEntity2> result = query.getResultList();

        for (ParentEntity2 parentEntity : result)
        {
            assertEquals("some child name",
                         parentEntity.getChilds()
                                     .iterator()
                                     .next()
                                     .getName());
            assertEquals("some parent name", parentEntity.getName());
        }
    }
}
