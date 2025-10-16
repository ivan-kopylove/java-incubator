package kopylove.named.compoundselection;

import jakarta.persistence.Column;

class OrganizationGeneralDetails03
{
    @Column(name = "GOAL")
    private String goal;

    @Column(name = "FOUND")
    private String found;

    @Column(name = "MOTTO")
    private String motto;

    @Column(name = "STRUCTURE")
    private String ogranizationalStructure;

    String getGoal()
    {
        return goal;
    }

    void setGoal(String goal)
    {
        this.goal = goal;
    }

    String getFound()
    {
        return found;
    }

    void setFound(String found)
    {
        this.found = found;
    }

    String getMotto()
    {
        return motto;
    }

    void setMotto(String motto)
    {
        this.motto = motto;
    }

    String getOgranizationalStructure()
    {
        return ogranizationalStructure;
    }

    void setOgranizationalStructure(String ogranizationalStructure)
    {
        this.ogranizationalStructure = ogranizationalStructure;
    }
}
