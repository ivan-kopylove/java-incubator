package kopylove.named.criteria.join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import kopylove.heap.EntityManagerProvider;
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

        ParentEntity02 parentEntity = new ParentEntity02();
        parentEntity.setId(100);
        parentEntity.setName("some parent name");

        ChildEntity02 childEntity = new ChildEntity02();
        childEntity.setKey(100);
        childEntity.setName("some child name");
        childEntity.setParent(parentEntity);

        EntityManager entityManager = EntityManagerProvider.getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(parentEntity);
        entityManager.persist(childEntity);

        entityManager.getTransaction().commit();
    }

    @Test
    void what_does_this_example_demonstrate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity02> cq = cb.createQuery(ParentEntity02.class);//result
        Root<ParentEntity02> root = cq.from(ParentEntity02.class);//to start from

        root.join("childs");
        cq.select(root);

        TypedQuery<ParentEntity02> query = entityManager.createQuery(cq);
        List<ParentEntity02> result = query.getResultList();

        for (ParentEntity02 parentEntity : result)
        {
            assertEquals("some child name", parentEntity.getChilds().iterator().next().getName());
            assertEquals("some parent name", parentEntity.getName());
        }
    }
}
