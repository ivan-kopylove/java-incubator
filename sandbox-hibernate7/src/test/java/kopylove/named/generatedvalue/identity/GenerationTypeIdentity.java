package kopylove.named.generatedvalue.identity;

import jakarta.persistence.EntityManager;
import kopylove.heap.dsasdasda.BaseSession;
import org.junit.jupiter.api.Test;

import static kopylove.heap.EntityManagerProvider.getEntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerationTypeIdentity extends BaseSession
{

    /// This example is intended to show basic working example of GenerationType.IDENTITY.
    @Test
    void generationTypeIdentity()
    {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        IdentityExampleEntity identityExampleEntity = new IdentityExampleEntity();

        int id = identityExampleEntity.getId();
        assertEquals(0, id);
        entityManager.persist(identityExampleEntity);
        assertEquals(++id, identityExampleEntity.getId());

        entityManager.getTransaction().commit();
    }
}

