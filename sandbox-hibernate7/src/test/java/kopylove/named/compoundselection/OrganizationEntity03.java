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

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }

    public OrganizationBuildingDetails03 getOrganizationBuildingDetails()
    {
        return organizationBuildingDetails;
    }

    public void setOrganizationBuildingDetails(OrganizationBuildingDetails03 organizationBuildingDetails)
    {
        this.organizationBuildingDetails = organizationBuildingDetails;
    }

    public OrganizationGeneralDetails03 getOrganizationGeneralDetails()
    {
        return organizationGeneralDetails;
    }

    public void setOrganizationGeneralDetails(OrganizationGeneralDetails03 organizationGeneralDetails)
    {
        this.organizationGeneralDetails = organizationGeneralDetails;
    }
}
