package kopylove.heap.a6;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class GeneratedValueSecond02
{
    @Id
    @GeneratedValue
    private long id;

    public long getId()
    {
        return id;
    }
}
