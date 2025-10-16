package kopylove.heap.c3d7;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class GeneratedValueSecond02
{
    @Id
    @GeneratedValue
    private long id;

    long getId()
    {
        return id;
    }
}
