package kopylove.named.flushmode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
class ParentEntity04
{
    @Id
    @Column(name = "PARENTTABLE_KEY", unique = true, nullable = false)
    private int id;

    @Column(name = "PARENTTABLE_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<ChildEntity04> children;

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

    Set<ChildEntity04> getChildren()
    {
        return children;
    }

    void setChildren(Set<ChildEntity04> childs)
    {
        this.children = new HashSet(childs);
    }
}
