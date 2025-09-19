package kopylove.persistence.hibernate.fixme01;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

        //@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
class BookEntity07
{
    @Id
    private int key;

    @Column(name = "BOOK_NAME")
    private String name;

    public int getId()
    {
        return key;
    }

    public void setId(int id)
    {
        this.key = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
