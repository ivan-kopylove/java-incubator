package kopylove.heap.d3f8;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
class ChildEntity10
{
    @Id
    @Column(name = "CHILDTABLE_KEY", unique = true, nullable = false)
    private Integer id;

    @Column(name = "CHILDTABLE_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CHILDTABLE_PARENT_KEY", nullable = false)
    private ParentEntity10 parent;

    Integer getId()
    {
        return id;
    }

    void setId(Integer id)
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

    ParentEntity10 getParent()
    {
        return parent;
    }

    void setParent(ParentEntity10 parent)
    {
        this.parent = parent;
    }
}
