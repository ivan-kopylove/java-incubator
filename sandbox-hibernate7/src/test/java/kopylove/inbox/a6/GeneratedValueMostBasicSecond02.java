package kopylove.inbox.a6;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/// drop sequence if exists MyGeneratorName
@Entity
class GeneratedValueMostBasicSecond02
{
    @Id
    @GeneratedValue
    private long id;

    public long getId()
    {
        return id;
    }
}
