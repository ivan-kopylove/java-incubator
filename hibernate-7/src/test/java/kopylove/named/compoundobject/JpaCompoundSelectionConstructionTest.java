package kopylove.named.compoundobject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CompoundSelection;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import kopylove.heap.b505.EntityManagerProvider;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JpaCompoundSelectionConstructionTest extends EntityManagerManual
{
    @BeforeAll
    public static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        OrganizationBuildingDetails01 organizationBuildingDetails = new OrganizationBuildingDetails01();
        organizationBuildingDetails.setAddress("Sadovnicheskaya Ulitsa 82, building 2, Moscow, Russia, 115035");
        organizationBuildingDetails.setFloors(5);
        organizationBuildingDetails.setWorkplaces(1000);

        OrganizationGeneralDetails01 generalDetails = new OrganizationGeneralDetails01();
        generalDetails.setFound("1997");
        generalDetails.setGoal("Make the world better");
        generalDetails.setMotto("Naidyotsa vsyo");
        generalDetails.setOgranizationalStructure("Vertical");

        OrganizationEntity01 organzation = new OrganizationEntity01();
        organzation.setKey(0);
        organzation.setOrganizationBuildingDetails(organizationBuildingDetails);
        organzation.setOrganizationGeneralDetails(generalDetails);

        entityManager.persist(organzation);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /// CompoundSelection filled according construct order.
    @Test
    void reverse_engineer_hypothetical_design_incorrect()
    {
        assertThrows(IllegalStateException.class, () -> {


            EntityManager entityManager = super.getEntityManager();
            entityManager.getTransaction().begin();

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CompoundObject01> query = builder.createQuery(CompoundObject01.class);
            Root<OrganizationEntity01> cgedRoot = query.from(OrganizationEntity01.class);

            CompoundSelection<CompoundObject01> compoundSelection = builder.construct(CompoundObject01.class,
                                                                                      cgedRoot.get(
                                                                                                      "organizationBuildingDetails")
                                                                                              .get("address"),
                                                                                      cgedRoot.get("key")); //incorrect order
            query.select(compoundSelection);
            List<CompoundObject01> resultList = entityManager.createQuery(query).getResultList();
        });
    }

    /// CompoundSelection filled according construct order.
    @Test
    void reverse_engineer_hypothetical_design_correct()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompoundObject01> query = builder.createQuery(CompoundObject01.class);
        Root<OrganizationEntity01> cgedRoot = query.from(OrganizationEntity01.class);

        CompoundSelection<CompoundObject01> compoundSelection = builder.construct(CompoundObject01.class,
                                                                                  cgedRoot.get("key"),
                                                                                  cgedRoot.get(
                                                                                                  "organizationBuildingDetails")
                                                                                          .get("address")); //correct order
        query.select(compoundSelection);
        List<CompoundObject01> resultList = entityManager.createQuery(query).getResultList();
        assertEquals(0, resultList.get(0).getA());
        assertEquals("Sadovnicheskaya Ulitsa 82, building 2, Moscow, Russia, 115035", resultList.get(0).getB());
    }
}
