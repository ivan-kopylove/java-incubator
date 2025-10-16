package kopylove.heap.ae36;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class OrganizationEntity02
{
    @Id
    @Column(name = "ORGANIZATION_KEY")
    private int key;

    @Embedded
    private OrganizationBuildingDetails02 organizationBuildingDetails;

    @Embedded
    private OrganizationGeneralDetails02 organizationGeneralDetails;

    int getKey()
    {
        return key;
    }

    void setKey(int key)
    {
        this.key = key;
    }

    OrganizationBuildingDetails02 getOrganizationBuildingDetails()
    {
        return organizationBuildingDetails;
    }

    void setOrganizationBuildingDetails(OrganizationBuildingDetails02 organizationBuildingDetails)
    {
        this.organizationBuildingDetails = organizationBuildingDetails;
    }

    OrganizationGeneralDetails02 getOrganizationGeneralDetails()
    {
        return organizationGeneralDetails;
    }

    void setOrganizationGeneralDetails(OrganizationGeneralDetails02 organizationGeneralDetails)
    {
        this.organizationGeneralDetails = organizationGeneralDetails;
    }
}
