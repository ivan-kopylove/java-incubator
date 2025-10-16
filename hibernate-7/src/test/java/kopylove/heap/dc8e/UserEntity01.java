package kopylove.heap.dc8e;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
class UserEntity01 implements Serializable
{
    @Id
    @Column(name = "USERS_LOGIN")
    private String name;

    @Id
    @Column(name = "USERS_SSN")
    private int ssn;

    @Column(name = "USERS_CITY")
    private String city;

    String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name = name;
    }

    int getSsn()
    {
        return ssn;
    }

    void setSsn(int ssn)
    {
        this.ssn = ssn;
    }

    String getCity()
    {
        return city;
    }

    void setCity(String city)
    {
        this.city = city;
    }
}
