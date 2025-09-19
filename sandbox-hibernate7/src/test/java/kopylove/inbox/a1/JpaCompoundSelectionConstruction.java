package kopylove.inbox.a1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CompoundSelection;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import kopylove.heap.EntityManagerProvider;
import kopylove.heap.dsasdasda.EntityManagerSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JpaCompoundSelectionConstruction extends EntityManagerSession
{
    @BeforeAll
    public static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        OrganizationBuildingDetails1 organizationBuildingDetails = new OrganizationBuildingDetails1();
        organizationBuildingDetails.setAddress("Sadovnicheskaya Ulitsa 82, building 2, Moscow, Russia, 115035");
        organizationBuildingDetails.setFloors(5);
        organizationBuildingDetails.setWorkplaces(1000);

        OrganizationGeneralDetails1 generalDetails = new OrganizationGeneralDetails1();
        generalDetails.setFound("1997");
        generalDetails.setGoal("Make the world better");
        generalDetails.setMotto("Naidyotsa vsyo");
        generalDetails.setOgranizationalStructure("Vertical");

        OrganizationEntity1 organzation = new OrganizationEntity1();
        organzation.setKey(0);
        organzation.setOrganizationBuildingDetails(organizationBuildingDetails);
        organzation.setOrganizationGeneralDetails(generalDetails);

        entityManager.persist(organzation);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /// CompoundSelection filled according construct order.
    @Test
    void run_incorrect()
    {
        assertThrows(IllegalStateException.class, () -> {


            EntityManager entityManager = EntityManagerProvider.getEntityManager();
            entityManager.getTransaction().begin();

            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CompoundObject1> query = builder.createQuery(CompoundObject1.class);
            Root<OrganizationEntity1> cgedRoot = query.from(OrganizationEntity1.class);

            CompoundSelection<CompoundObject1> compoundSelection = builder.construct(CompoundObject1.class,
                                                                                     cgedRoot.get(
                                                                                                     "organizationBuildingDetails")
                                                                                             .get("address"),
                                                                                     cgedRoot.get("key")); //incorrect order
            query.select(compoundSelection);
            List<CompoundObject1> resultList = entityManager.createQuery(query).getResultList();
        });
    }

    /// CompoundSelection filled according construct order.
    @Test
    void run_correct()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompoundObject1> query = builder.createQuery(CompoundObject1.class);
        Root<OrganizationEntity1> cgedRoot = query.from(OrganizationEntity1.class);

        CompoundSelection<CompoundObject1> compoundSelection = builder.construct(CompoundObject1.class,
                                                                                 cgedRoot.get("key"),
                                                                                 cgedRoot.get(
                                                                                                 "organizationBuildingDetails")
                                                                                         .get("address")); //correct order
        query.select(compoundSelection);
        List<CompoundObject1> resultList = entityManager.createQuery(query).getResultList();
        assertEquals(0, resultList.get(0).getA());
        assertEquals("Sadovnicheskaya Ulitsa 82, building 2, Moscow, Russia, 115035", resultList.get(0).getB());
    }
}
