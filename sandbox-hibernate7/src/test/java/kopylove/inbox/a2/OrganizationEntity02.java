package kopylove.inbox.a2;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORGANIZATION")
class OrganizationEntity02
{
    @Id
    @Column(name = "ORGANIZATION_KEY")
    private int key;

    @Embedded
    private OrganizationBuildingDetails02 organizationBuildingDetails;

    @Embedded
    private OrganizationGeneralDetails02 organizationGeneralDetails;

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }

    public OrganizationBuildingDetails02 getOrganizationBuildingDetails()
    {
        return organizationBuildingDetails;
    }

    public void setOrganizationBuildingDetails(OrganizationBuildingDetails02 organizationBuildingDetails)
    {
        this.organizationBuildingDetails = organizationBuildingDetails;
    }

    public OrganizationGeneralDetails02 getOrganizationGeneralDetails()
    {
        return organizationGeneralDetails;
    }

    public void setOrganizationGeneralDetails(OrganizationGeneralDetails02 organizationGeneralDetails)
    {
        this.organizationGeneralDetails = organizationGeneralDetails;
    }
}
