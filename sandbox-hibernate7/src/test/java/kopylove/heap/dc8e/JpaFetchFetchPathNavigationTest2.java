package kopylove.heap.dc8e;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import kopylove.heap.b505.EntityManagerProvider;
import kopylove.heap.e70a.EntityManagerSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

/// - [https://stackoverflow.com/questions/4511368/](https://stackoverflow.com/questions/4511368/)
class JpaFetchFetchPathNavigationTest2 extends EntityManagerSession
{
    private static final String USER_NAME_ONE = "a";
    private static final String USER_NAME_TWO = "b";

    @BeforeAll
    public static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        UserEntity01 user = new UserEntity01();
        user.setName(USER_NAME_ONE);

        UserEntity01 user2 = new UserEntity01();
        user2.setName(USER_NAME_TWO);

        OrderEntity02 order = new OrderEntity02();
        order.setUser(user);

        OrderEntity02 order2 = new OrderEntity02();
        order2.setUser(user2);

        entityManager.persist(user2);
        entityManager.persist(user);
        entityManager.persist(order);
        entityManager.persist(order2);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void join_fetch_together()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderEntity02> cq = builder.createQuery(OrderEntity02.class);
        Root<OrderEntity02> root = cq.from(OrderEntity02.class);

        Join<OrderEntity02, UserEntity01> user = root.join("user");
        root.fetch("user"); //duplicated join will be generated, but the goal is achieved: projections are specified by hibernate in sql query

        Predicate name = builder.equal(user.get("name"), USER_NAME_ONE);
        cq.where(name);
        cq.select(root);

        TypedQuery<OrderEntity02> query = entityManager.createQuery(cq);
        List<OrderEntity02> result = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void cast_to_join()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderEntity02> cq = builder.createQuery(OrderEntity02.class);
        Root<OrderEntity02> root = cq.from(OrderEntity02.class);

        Join<OrderEntity02, UserEntity01> user = (Join) root.fetch("user");


        Predicate name = builder.equal(user.get("name"), USER_NAME_ONE);
        cq.where(name);
        cq.select(root);

        TypedQuery<OrderEntity02> query = entityManager.createQuery(cq);
        List<OrderEntity02> result = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
