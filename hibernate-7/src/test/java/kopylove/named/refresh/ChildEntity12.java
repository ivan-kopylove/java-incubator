package kopylove.named.refresh;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
class ChildEntity12
{
    @Id
    @Column(name = "CHILDTABLE_KEY", unique = true, nullable = false)
    private Integer key;

    @Column(name = "CHILDTABLE_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CHILDTABLE_PARENT_KEY", nullable = false)
    private ParentEntity12 parent;

    Integer getKey()
    {
        return key;
    }

    void setKey(Integer key)
    {
        this.key = key;
    }

    String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name = name;
    }

    ParentEntity12 getParent()
    {
        return parent;
    }

    void setParent(ParentEntity12 parent)
    {
        this.parent = parent;
    }
}
