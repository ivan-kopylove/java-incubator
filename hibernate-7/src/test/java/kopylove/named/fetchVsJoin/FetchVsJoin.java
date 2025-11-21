package kopylove.named.fetchVsJoin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.Test;

/// In this two examples, JOIN query is used to load. They have certain difference.
class FetchVsJoin extends EntityManagerManual
{
    /// Join will not add information to the generated SQL query projection, so, no chance for hibernate to cache joined entity.
    @Test
    void join()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction()
                     .begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Gamer> cq = builder.createQuery(Gamer.class);
        Root<Gamer> root = cq.from(Gamer.class);

        root.join("game");

        TypedQuery<Gamer> query = entityManager.createQuery(cq);
        query.getResultList();

        entityManager.getTransaction()
                     .commit();
        entityManager.close();
    }

    /// Hibernate adds projections to joined table, so data is returned into Hibernate, so that Hibernate can cache this data.
    @Test
    void fetch()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction()
                     .begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Gamer> cq = builder.createQuery(Gamer.class);
        Root<Gamer> root = cq.from(Gamer.class);

        root.fetch("game");

        TypedQuery<Gamer> query = entityManager.createQuery(cq);
        query.getResultList();

        entityManager.getTransaction()
                     .commit();
        entityManager.close();
    }
}
