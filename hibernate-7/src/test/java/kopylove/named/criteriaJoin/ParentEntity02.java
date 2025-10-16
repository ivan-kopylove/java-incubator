package kopylove.named.criteriaJoin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
class ParentEntity02
{
    @Id
    @Column(name = "PARENTTABLE_KEY", unique = true, nullable = false)
    private int id;

    @Column(name = "PARENTTABLE_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<ChildEntity02> childs;

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

    Set<ChildEntity02> getChilds()
    {
        return childs;
    }

    void setChildren(Set<ChildEntity02> childs)
    {
        this.childs = new HashSet(childs);
    }
}
