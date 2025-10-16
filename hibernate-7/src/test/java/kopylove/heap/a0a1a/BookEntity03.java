package kopylove.heap.a0a1a;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

        //@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
class BookEntity03
{
    @Id
    @Column(name = "BOOK_KEY")
    private int id;

    @Column(name = "BOOK_NAME")
    private String name;

    int getId()
    {
        return id;
    }

    void setId(int id)
    {
        this.id = id;
    }

    String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name = name;
    }
}
