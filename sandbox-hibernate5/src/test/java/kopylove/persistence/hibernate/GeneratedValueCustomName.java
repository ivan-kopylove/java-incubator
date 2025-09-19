package kopylove.persistence.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/// drop sequence if exists MyGeneratorName
@Entity
class GeneratedValueCustomName
{
    @Id
    @GeneratedValue(generator = "MyGeneratorName")
    private long key;

    public long getKey()
    {
        return key;
    }

    public void setKey(long key)
    {
        this.key = key;
    }
}
