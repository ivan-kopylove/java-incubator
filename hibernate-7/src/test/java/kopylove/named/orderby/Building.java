package kopylove.named.orderby;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;

import java.util.List;

@Entity
class Building
{
    @Id
    private long         id;
    @ElementCollection
    @OrderBy
    private List<String> phoneNumbers;

    long getId()
    {
        return id;
    }

    void setId(long id)
    {
        this.id = id;
    }

    List<String> getPhoneNumbers()
    {
        return phoneNumbers;
    }

    void setPhoneNumbers(List<String> phoneNumbers)
    {
        this.phoneNumbers = phoneNumbers;
    }
}
