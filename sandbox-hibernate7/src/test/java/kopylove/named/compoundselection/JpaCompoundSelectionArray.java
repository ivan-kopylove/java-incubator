package kopylove.named.compoundselection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CompoundSelection;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import kopylove.heap.EntityManagerProvider;
import kopylove.heap.dsasdasda.EntitiManagerSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JpaCompoundSelectionArray extends EntitiManagerSession
{
    @BeforeAll
    public static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        OrganizationBuildingDetails organizationBuildingDetails = new OrganizationBuildingDetails();
        organizationBuildingDetails.setAddress("Sadovnicheskaya Ulitsa 82, building 2, Moscow, Russia, 115035");
        organizationBuildingDetails.setFloors(5);
        organizationBuildingDetails.setWorkplaces(1000);

        OrganizationGeneralDetails generalDetails = new OrganizationGeneralDetails();
        generalDetails.setFound("1997");
        generalDetails.setGoal("Make the world better");
        generalDetails.setMotto("Naidyotsa vsyo");
        generalDetails.setOgranizationalStructure("Vertical");

        OrganizationEntity organzation = new OrganizationEntity();
        organzation.setKey(0);
        organzation.setOrganizationBuildingDetails(organizationBuildingDetails);
        organzation.setOrganizationGeneralDetails(generalDetails);

        entityManager.persist(organzation);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void run_correct()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<OrganizationEntity> root = query.from(OrganizationEntity.class);

        CompoundSelection<Object[]> compoundSelection = builder.array(root.get("key"),
                                                                      root.get("organizationGeneralDetails")
                                                                          .get("ogranizationalStructure"));

        query.select(compoundSelection);
        Object[] resultList = entityManager.createQuery(query).getSingleResult();
        assertNotNull(resultList[0]);
        assertEquals("Vertical", resultList[1]);
    }
}
