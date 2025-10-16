package kopylove.heap.a0a1a;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
class PageEntity03
{
    @Id
    @Column(name = "PAGE_KEY")
    private int key;

    @ManyToOne(targetEntity = BookEntity03.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_KEY")
    private BookEntity03 book;

    @Column(name = "PAGE_NAME")
    private String name;

    @Column(name = "PAGE_ANNOTATIONS")
    private String annotations;

    int getKey()
    {
        return key;
    }

    void setKey(int key)
    {
        this.key = key;
    }

    BookEntity03 getBook()
    {
        return book;
    }

    void setBook(BookEntity03 book)
    {
        this.book = book;
    }

    String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name = name;
    }

    String getAnnotations()
    {
        return annotations;
    }

    void setAnnotations(String annotations)
    {
        this.annotations = annotations;
    }
}
