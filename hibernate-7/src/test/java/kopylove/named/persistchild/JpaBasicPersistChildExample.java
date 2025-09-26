package kopylove.named.persistchild;

import jakarta.persistence.EntityManager;
import kopylove.heap.b505.EntityManagerProvider;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class JpaBasicPersistChildExample
{
    @Test
    void reverse_engineer_hypothetical_design_of_the_example()
    {


        Set<ChildEntity07> childen = new HashSet<>();

        ParentEntity07 parentEntity = new ParentEntity07();
        parentEntity.setId(new Random().nextInt(1000));
        parentEntity.setName("c");
        parentEntity.setChildren(childen);

        ChildEntity07 childEntity = new ChildEntity07();
        childEntity.setKey(new Random().nextInt(1000));
        childEntity.setName("a");
        childEntity.setParent(parentEntity);
        childen.add(childEntity);

        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        em.persist(parentEntity);
        em.getTransaction().commit();
    }
}
