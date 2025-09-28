package kopylove.named.compoundselection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CompoundSelection;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import kopylove.heap.b505.EntityManagerProvider;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JpaCompoundSelectionArrayTest extends EntityManagerManual
{
    @BeforeAll
    public static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        OrganizationBuildingDetails03 organizationBuildingDetails = new OrganizationBuildingDetails03();
        organizationBuildingDetails.setAddress("Sadovnicheskaya Ulitsa 82, building 2, Moscow, Russia, 115035");
        organizationBuildingDetails.setFloors(5);
        organizationBuildingDetails.setWorkplaces(1000);

        OrganizationGeneralDetails03 generalDetails = new OrganizationGeneralDetails03();
        generalDetails.setFound("1997");
        generalDetails.setGoal("Make the world better");
        generalDetails.setMotto("Naidyotsa vsyo");
        generalDetails.setOgranizationalStructure("Vertical");

        OrganizationEntity03 organzation = new OrganizationEntity03();
        organzation.setKey(0);
        organzation.setOrganizationBuildingDetails(organizationBuildingDetails);
        organzation.setOrganizationGeneralDetails(generalDetails);

        entityManager.persist(organzation);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void exercise_design_reverse_engineering_correct()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<OrganizationEntity03> root = query.from(OrganizationEntity03.class);

        CompoundSelection<Object[]> compoundSelection = builder.array(root.get("key"),
                                                                      root.get("organizationGeneralDetails")
                                                                          .get("ogranizationalStructure"));

        query.select(compoundSelection);
        Object[] resultList = entityManager.createQuery(query).getSingleResult();
        assertNotNull(resultList[0]);
        assertEquals("Vertical", resultList[1]);
    }
}
