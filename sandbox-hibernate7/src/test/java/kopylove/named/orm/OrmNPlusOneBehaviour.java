package kopylove.named.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static kopylove.heap.EntityManagerProvider.getEntityManager;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/// ORM N+1 problem demonstration
class OrmNPlusOneBehaviour
{
    @BeforeAll
    public static void populate()
    {
        Random random = new Random();

        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        for (int i = 7; i < 12; i++)
        {
            ParentEntity6 parent = new ParentEntity6();
            parent.setId(i);
            parent.setName(String.valueOf(random.nextInt(99999)));

            ChildEntity6 child = new ChildEntity6();
            child.setKey(i);
            child.setName(String.valueOf(random.nextInt(99999)));
            child.setParent(parent);

            entityManager.persist(parent);
            entityManager.persist(child);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /// No additional queries without proxy's getter call
    @Test
    void noDbHits()
    {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity6> cr = cb.createQuery(ParentEntity6.class);
        Root<ParentEntity6> root = cr.from(ParentEntity6.class);
        cr.select(root);

        List<ParentEntity6> parents = entityManager.createQuery(cr).getResultList();

        for (ParentEntity6 parent : parents)
        {
            Set<ChildEntity6> childs = parent.getChilds();
        }

        entityManager.close();
    }

    /// N+1 additional queries when accessing db through child proxy
    @Test
    void nPlusOne()
    {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity6> cr = cb.createQuery(ParentEntity6.class);
        Root<ParentEntity6> root = cr.from(ParentEntity6.class);
        cr.select(root);

        TypedQuery<ParentEntity6> query = entityManager.createQuery(cr);
        List<ParentEntity6> parents = query.getResultList();

        for (ParentEntity6 parent : parents)
        {
            Set<ChildEntity6> childs = parent.getChilds(); //each call is a db hit
            for (int i = 0; i < childs.size(); i++)
            {
                childs.iterator();
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void solutionIsFetch()
    {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity6> cq = builder.createQuery(ParentEntity6.class);
        Root<ParentEntity6> root = cq.from(ParentEntity6.class);

        root.fetch("childs");
        cq.select(root);

        List<ParentEntity6> parents = entityManager.createQuery(cq).getResultList();

//        entityManager.close();

        for (ParentEntity6 parent : parents)
        {
            Set<ChildEntity6> childs = parent.getChilds();
            for (ChildEntity6 childEntity : childs)
            {
                assertNotNull(childEntity.getName());
            }
        }

        entityManager.getTransaction().commit();
    }

    @Test
    void joinIsntASolution()
    {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity6> cq = builder.createQuery(ParentEntity6.class);
        Root<ParentEntity6> root = cq.from(ParentEntity6.class);

        root.join("childs");
        cq.select(root);

        List<ParentEntity6> parents = entityManager.createQuery(cq).getResultList();



        System.out.println("---- FINISHED -----");

        for (ParentEntity6 parent : parents)
        {
            Set<ChildEntity6> childs = parent.getChilds();
            for (ChildEntity6 childEntity : childs)
            {
                assertNotNull(childEntity.getName());
            }
        }
    }
}
