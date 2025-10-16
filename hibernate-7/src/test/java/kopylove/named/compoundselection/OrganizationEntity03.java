package kopylove.named.compoundselection;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class OrganizationEntity03
{
    @Id
    @Column(name = "ORGANIZATION_KEY")
    private int key;

    @Embedded
    private OrganizationBuildingDetails03 organizationBuildingDetails;

    @Embedded
    private OrganizationGeneralDetails03 organizationGeneralDetails;

    int getKey()
    {
        return key;
    }

    void setKey(int key)
    {
        this.key = key;
    }

    OrganizationBuildingDetails03 getOrganizationBuildingDetails()
    {
        return organizationBuildingDetails;
    }

    void setOrganizationBuildingDetails(OrganizationBuildingDetails03 organizationBuildingDetails)
    {
        this.organizationBuildingDetails = organizationBuildingDetails;
    }

    OrganizationGeneralDetails03 getOrganizationGeneralDetails()
    {
        return organizationGeneralDetails;
    }

    void setOrganizationGeneralDetails(OrganizationGeneralDetails03 organizationGeneralDetails)
    {
        this.organizationGeneralDetails = organizationGeneralDetails;
    }
}
