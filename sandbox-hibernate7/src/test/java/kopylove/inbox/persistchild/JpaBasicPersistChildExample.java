package kopylove.inbox.persistchild;

import jakarta.persistence.EntityManager;
import kopylove.heap.EntityManagerProvider;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class JpaBasicPersistChildExample
{
    @Test
    void what_does_this_example_demonstrate()
    {


        Set<ChildEntity07> childs = new HashSet<>();

        ParentEntity07 parentEntity = new ParentEntity07();
        parentEntity.setId(new Random().nextInt(1000));
        parentEntity.setName("c");
        parentEntity.setChilds(childs);

        ChildEntity07 childEntity = new ChildEntity07();
        childEntity.setKey(new Random().nextInt(1000));
        childEntity.setName("a");
        childEntity.setParent(parentEntity);
        childs.add(childEntity);

        EntityManager em = EntityManagerProvider.getEntityManager();
        em.getTransaction().begin();
        em.persist(parentEntity);
        em.getTransaction().commit();
    }
}
