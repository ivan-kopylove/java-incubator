package kopylove.named.criteria.join;



import kopylove.heap.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;







import java.util.List;

class ElemCollectionJoin
{
    @Test
    void what_does_this_example_demonstrate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> cr = cb.createQuery(Ticket.class);
        Root<Ticket> root = cr.from(Ticket.class);
        cr.select(root);

        Join<Object, Object> objectObjectObjectMapJoin = root.join("ticketDetails")
                                                             .join("genericProperties")
                                                             .join("properties");

        TypedQuery<Ticket> query = entityManager.createQuery(cr);
        List<Ticket> parents = query.getResultList();

        if (parents.size() > 0)
        {
            parents.get(0)
                   .getTicketDetails()
                   .getGenericProperties()
                   .getProperties();
        }
    }
}
