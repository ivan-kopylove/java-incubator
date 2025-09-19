package kopylove.named.cascade;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
class PersonEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int                 id;
    private String              name;
    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<AddressEntity> addresses;

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<AddressEntity> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses)
    {
        this.addresses = addresses;
    }
}
