package kopylove.inbox.a7;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAGE")
class PageEntity3
{
    @Id
    @Column(name = "PAGE_KEY")
    private int key;

    @ManyToOne(targetEntity = BookEntity3.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_KEY")
    private BookEntity3 book;

    @Column(name = "PAGE_NAME")
    private String name;

    @Column(name = "PAGE_ANNOTATIONS")
    private String annotations;

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }

    public BookEntity3 getBook()
    {
        return book;
    }

    public void setBook(BookEntity3 book)
    {
        this.book = book;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAnnotations()
    {
        return annotations;
    }

    public void setAnnotations(String annotations)
    {
        this.annotations = annotations;
    }
}
