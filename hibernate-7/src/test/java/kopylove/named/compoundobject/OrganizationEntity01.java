package kopylove.named.compoundobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class OrganizationEntity01
{
    @Id
    @Column(name = "ORGANIZATION_KEY")
    private int key;

    @Embedded
    private OrganizationBuildingDetails01 organizationBuildingDetails;

    @Embedded
    private OrganizationGeneralDetails01 organizationGeneralDetails;

    int getKey()
    {
        return key;
    }

    void setKey(int key)
    {
        this.key = key;
    }

    OrganizationBuildingDetails01 getOrganizationBuildingDetails()
    {
        return organizationBuildingDetails;
    }

    void setOrganizationBuildingDetails(OrganizationBuildingDetails01 organizationBuildingDetails)
    {
        this.organizationBuildingDetails = organizationBuildingDetails;
    }

    OrganizationGeneralDetails01 getOrganizationGeneralDetails()
    {
        return organizationGeneralDetails;
    }

    void setOrganizationGeneralDetails(OrganizationGeneralDetails01 organizationGeneralDetails)
    {
        this.organizationGeneralDetails = organizationGeneralDetails;
    }
}
