package kopylove.named.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import kopylove.heap.EntityManagerProvider;
import org.junit.jupiter.api.Test;

import java.util.List;

class JpaCriteriaBuilderBasicExampleTest
{
    @Test
    void what_does_this_example_demonstrate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity01> cr = cb.createQuery(ParentEntity01.class);
        Root<ParentEntity01> root = cr.from(ParentEntity01.class);
        cr.select(root);

        TypedQuery<ParentEntity01> query = entityManager.createQuery(cr);
        List<ParentEntity01> list = query.getResultList();

        for (ParentEntity01 parentEntity : list)
        {
            System.out.println(parentEntity.getName());
        }
    }
}
