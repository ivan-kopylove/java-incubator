package d7d7;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
class Person
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "ssn", nullable = false, unique = true)
    private String ssn;

    Person()
    {
    }

    Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Person(String firstName, String lastName, String ssn)
    {
        this(firstName, lastName);
        this.ssn = ssn;
    }

    Integer getId()
    {
        return id;
    }

    void setId(Integer id)
    {
        this.id = id;
    }

    String getFirstName()
    {
        return firstName;
    }

    void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    String getLastName()
    {
        return lastName;
    }

    void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    String getSsn()
    {
        return ssn;
    }

    void setSsn(String ssn)
    {
        this.ssn = ssn;
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }
}