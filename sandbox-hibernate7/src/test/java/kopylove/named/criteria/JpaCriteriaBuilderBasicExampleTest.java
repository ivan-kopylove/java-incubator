package kopylove.named.criteria;



import kopylove.heap.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;






import java.util.List;

class JpaCriteriaBuilderBasicExampleTest
{
    @Test
    void what_does_this_example_demonstrate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParentEntity1> cr = cb.createQuery(ParentEntity1.class);
        Root<ParentEntity1> root = cr.from(ParentEntity1.class);
        cr.select(root);

        TypedQuery<ParentEntity1> query = entityManager.createQuery(cr);
        List<ParentEntity1> list = query.getResultList();

        for (ParentEntity1 parentEntity : list)
        {
            System.out.println(parentEntity.getName());
        }
    }
}
