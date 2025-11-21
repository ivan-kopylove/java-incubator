package kopylove.named.merge;

import jakarta.persistence.EntityManager;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// Difference vs merge and persist

class JpaMergeExampleTest extends EntityManagerManual
{
    @Test
    void merge_set_new_name_original_object()
    {
        ParentEntity08 initialEntity = new ParentEntity08();
        initialEntity.setId(1);
        initialEntity.setName("initial name");

        EntityManager entityManger = super.getEntityManager();
        entityManger.getTransaction()
                    .begin();
        ParentEntity08 merged = entityManger.merge(initialEntity);//copies the state from the supplied entity, and makes the new copy managed.

        initialEntity.setName("initial updated name");

        entityManger.getTransaction()
                    .commit();

        entityManger.close();

        entityManger = super.getEntityManager();
        ParentEntity08 reloadedEntity = entityManger.find(ParentEntity08.class, 1);
        assertEquals("initial name", reloadedEntity.getName());
        assertEquals("initial name", merged.getName());
        assertEquals("initial updated name", initialEntity.getName());
        entityManger.close();
    }

    @Test
    void merge_set_new_name_merged_object()
    {
        ParentEntity08 initialEntity = new ParentEntity08();
        initialEntity.setId(2);
        initialEntity.setName("initial name");

        EntityManager entityManger = super.getEntityManager();
        entityManger.getTransaction()
                    .begin();
        ParentEntity08 merged = entityManger.merge(initialEntity);//copies the state from the supplied entity, and makes the new copy managed.

        merged.setName("merged updated name");

        entityManger.getTransaction()
                    .commit();

        entityManger.close();

        entityManger = super.getEntityManager();
        ParentEntity08 reloadedEntity = entityManger.find(ParentEntity08.class, 2);
        assertEquals("merged updated name", reloadedEntity.getName());
        assertEquals("merged updated name", merged.getName());
        assertEquals("initial name", initialEntity.getName());
        entityManger.close();
    }

    @Test
    void persist_then_merge()
    {
        ParentEntity08 entity1 = new ParentEntity08();
        entity1.setId(3);
        entity1.setName("entity 1");

        ParentEntity08 entity2 = new ParentEntity08();
        entity2.setId(3);
        entity2.setName("entity 2");

        //save to db and commit
        EntityManager entityManger = super.getEntityManager();
        entityManger.getTransaction()
                    .begin();
        entityManger.persist(entity1);
        entityManger.getTransaction()
                    .commit();
        entityManger.close();

        //update detached entity with the same id
        entityManger = super.getEntityManager();
        entityManger.getTransaction()
                    .begin();
        entityManger.merge(entity2);
        entityManger.getTransaction()
                    .commit();
        entityManger.close();
    }

    @Test
    void persist()
    {
        ParentEntity08 originalEntity = new ParentEntity08();
        originalEntity.setId(4);
        originalEntity.setName("old parent name");

        EntityManager entityManger = super.getEntityManager();
        entityManger.getTransaction()
                    .begin();
        entityManger.persist(originalEntity);//makes supplied entity managed

        originalEntity.setName("new parent name");

        entityManger.getTransaction()
                    .commit();

        entityManger.close();

        entityManger = super.getEntityManager();
        ParentEntity08 parentEntity1 = entityManger.find(ParentEntity08.class, 4);
        assertEquals("new parent name", parentEntity1.getName());
        entityManger.close();
    }
}
