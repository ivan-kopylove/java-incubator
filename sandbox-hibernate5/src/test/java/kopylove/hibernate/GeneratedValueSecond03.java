package kopylove.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/// drop sequence if exists MyGeneratorName
@Entity
class GeneratedValueSecond03
{
    @Id
    @GeneratedValue
    private long key;

    public long getKey()
    {
        return key;
    }
}
