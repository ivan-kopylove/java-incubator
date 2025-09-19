package kopylove.koans.fixme02;

import kopylove.hibernate.HibernateSessionFactory;
import kopylove.koans.fixme02.a01.GeneratedValueUuid99;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/// [...](https://docs.jboss.org/hibernate/core/3.6/reference/en-US/html/mapping.html#d0e5294)
class HibernateGenericGeneratorUuid
{
    @Test
    void what_does_this_example_demonstrate()
    {
        GeneratedValueUuid99 generatedKey = new GeneratedValueUuid99();

        Session session = HibernateSessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(generatedKey);
        session.getTransaction().commit();
        session.close();

        assertNotNull(generatedKey.getId());
        assertInstanceOf(String.class, generatedKey.getId());
        assertEquals(32, generatedKey.getId().length());
    }
}
