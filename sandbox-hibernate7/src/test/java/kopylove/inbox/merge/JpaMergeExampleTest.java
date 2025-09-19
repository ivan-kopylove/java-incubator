package kopylove.inbox.merge;

import jakarta.persistence.EntityManager;
import kopylove.heap.EntityManagerProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// Difference vs merge and persist
class JpaMergeExampleTest
{
    @Test
    void merge_set_new_name_original_object()
    {
        ParentEntity8 initialEntity = new ParentEntity8();
        initialEntity.setId(1);
        initialEntity.setName("initial name");

        EntityManager entityManger = EntityManagerProvider.getEntityManager();
        entityManger.getTransaction().begin();
        ParentEntity8 merged = entityManger.merge(initialEntity);//copies the state from the supplied entity, and makes the new copy managed.

        initialEntity.setName("initial updated name");

        entityManger.getTransaction().commit();

        entityManger.close();

        entityManger = EntityManagerProvider.getEntityManager();
        ParentEntity8 reloadedEntity = entityManger.find(ParentEntity8.class, 1);
        assertEquals("initial name", reloadedEntity.getName());
        assertEquals("initial name", merged.getName());
        assertEquals("initial updated name", initialEntity.getName());
        entityManger.close();
    }

    @Test
    void merge_set_new_name_merged_object()
    {
        ParentEntity8 initialEntity = new ParentEntity8();
        initialEntity.setId(2);
        initialEntity.setName("initial name");

        EntityManager entityManger = EntityManagerProvider.getEntityManager();
        entityManger.getTransaction().begin();
        ParentEntity8 merged = entityManger.merge(initialEntity);//copies the state from the supplied entity, and makes the new copy managed.

        merged.setName("merged updated name");

        entityManger.getTransaction().commit();

        entityManger.close();

        entityManger = EntityManagerProvider.getEntityManager();
        ParentEntity8 reloadedEntity = entityManger.find(ParentEntity8.class, 2);
        assertEquals("merged updated name", reloadedEntity.getName());
        assertEquals("merged updated name", merged.getName());
        assertEquals("initial name", initialEntity.getName());
        entityManger.close();
    }

    @Test
    void persist_then_merge()
    {
        ParentEntity8 entity1 = new ParentEntity8();
        entity1.setId(3);
        entity1.setName("entity 1");

        ParentEntity8 entity2 = new ParentEntity8();
        entity2.setId(3);
        entity2.setName("entity 2");

        //save to db and commit
        EntityManager entityManger = EntityManagerProvider.getEntityManager();
        entityManger.getTransaction().begin();
        entityManger.persist(entity1);
        entityManger.getTransaction().commit();
        entityManger.close();

        //update detached entity with the same id
        entityManger = EntityManagerProvider.getEntityManager();
        entityManger.getTransaction().begin();
        entityManger.merge(entity2);
        entityManger.getTransaction().commit();
        entityManger.close();
    }

    @Test
    void persist()
    {
        ParentEntity8 originalEntity = new ParentEntity8();
        originalEntity.setId(4);
        originalEntity.setName("old parent name");

        EntityManager entityManger = EntityManagerProvider.getEntityManager();
        entityManger.getTransaction().begin();
        entityManger.persist(originalEntity);//makes supplied entity managed

        originalEntity.setName("new parent name");

        entityManger.getTransaction().commit();

        entityManger.close();

        entityManger = EntityManagerProvider.getEntityManager();
        ParentEntity8 parentEntity1 = entityManger.find(ParentEntity8.class, 4);
        assertEquals("new parent name", parentEntity1.getName());
        entityManger.close();
    }
}
