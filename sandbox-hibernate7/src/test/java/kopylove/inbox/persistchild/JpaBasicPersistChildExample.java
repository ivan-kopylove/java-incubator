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
    void foo()
    {


        Set<ChildEntity7> childs = new HashSet<>();

        ParentEntity7 parentEntity = new ParentEntity7();
        parentEntity.setId(new Random().nextInt(1000));
        parentEntity.setName("c");
        parentEntity.setChilds(childs);

        ChildEntity7 childEntity = new ChildEntity7();
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
