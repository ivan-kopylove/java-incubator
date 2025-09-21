package kopylove.heap.ae36;

import jakarta.persistence.EntityManager;
import kopylove.heap.b505.EntityManagerProvider;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// @Embedded annotation demonstration.
class JpaEmbededAnnotationExampleTest extends EntityManagerManual
{
    @BeforeAll
    public static void populate()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        OrganizationBuildingDetails02 organizationBuildingDetails = new OrganizationBuildingDetails02();
        organizationBuildingDetails.setAddress("Sadovnicheskaya Ulitsa 82, building 2, Moscow, Russia, 115035");
        organizationBuildingDetails.setFloors(5);
        organizationBuildingDetails.setWorkplaces(1000);

        OrganizationGeneralDetails02 generalDetails = new OrganizationGeneralDetails02();
        generalDetails.setFound("1997");
        generalDetails.setGoal("Make the world better");
        generalDetails.setMotto("Naidyotsa vsyo");
        generalDetails.setOgranizationalStructure("Vertical");

        OrganizationEntity02 organzation = new OrganizationEntity02();
        organzation.setKey(0);
        organzation.setOrganizationBuildingDetails(organizationBuildingDetails);
        organzation.setOrganizationGeneralDetails(generalDetails);

        entityManager.persist(organzation);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void what_does_this_example_demonstrate()
    {
        // given
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        // when
        OrganizationEntity02 organization = entityManager.find(OrganizationEntity02.class, 0);

        // then
        assertEquals(5, organization.getOrganizationBuildingDetails().getFloors());
        assertEquals("1997", organization.getOrganizationGeneralDetails().getFound());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
