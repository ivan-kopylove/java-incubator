package kopylove.heap.ae36;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
class OrganizationBuildingDetails02
{
    @Column(name = "WORKPLACES")
    private int    workplaces;
    @Column(name = "FLOORS")
    private int    floors;
    @Column(name = "ADDRESS")
    private String address;

    int getWorkplaces()
    {
        return workplaces;
    }

    void setWorkplaces(int workplaces)
    {
        this.workplaces = workplaces;
    }

    int getFloors()
    {
        return floors;
    }

    void setFloors(int floors)
    {
        this.floors = floors;
    }

    String getAddress()
    {
        return address;
    }

    void setAddress(String address)
    {
        this.address = address;
    }
}
