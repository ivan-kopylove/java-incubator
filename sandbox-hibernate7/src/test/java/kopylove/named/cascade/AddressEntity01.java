package kopylove.named.cascade;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
class AddressEntity01
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int          id;
    private String       street;
    private int          houseNumber;
    private String       city;
    private int            zipCode;
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonEntity01 person;

    public int getId()
    {
        return id;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public int getHouseNumber()
    {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    public PersonEntity01 getPerson()
    {
        return person;
    }

    public void setPerson(PersonEntity01 person)
    {
        this.person = person;
    }
}