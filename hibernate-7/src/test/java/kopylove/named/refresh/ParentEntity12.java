package kopylove.named.refresh;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
class ParentEntity12
{
    @Id
    @Column(name = "PARENTTABLE_KEY", unique = true, nullable = false)
    private int id;

    @Column(name = "PARENTTABLE_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<ChildEntity12> children;

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

    Set<ChildEntity12> getChildren()
    {
        return children;
    }

    void setChildren(Set<ChildEntity12> childs)
    {
        this.children = new HashSet(childs);
    }
}
