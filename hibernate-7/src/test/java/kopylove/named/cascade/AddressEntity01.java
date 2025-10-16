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
    private int            id;
    private String         street;
    private int            houseNumber;
    private String         city;
    private int            zipCode;
    @ManyToOne(fetch = FetchType.LAZY)
    private PersonEntity01 person;

    int getId()
    {
        return id;
    }

    String getStreet()
    {
        return street;
    }

    void setStreet(String street)
    {
        this.street = street;
    }

    int getHouseNumber()
    {
        return houseNumber;
    }

    void setHouseNumber(int houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    String getCity()
    {
        return city;
    }

    void setCity(String city)
    {
        this.city = city;
    }

    int getZipCode()
    {
        return zipCode;
    }

    void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    PersonEntity01 getPerson()
    {
        return person;
    }

    void setPerson(PersonEntity01 person)
    {
        this.person = person;
    }
}