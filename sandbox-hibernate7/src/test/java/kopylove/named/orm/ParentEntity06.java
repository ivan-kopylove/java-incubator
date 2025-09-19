package kopylove.named.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
class ParentEntity06
{
    @Id
    @Column(name = "PARENTTABLE_KEY", unique = true, nullable = false)
    private int id;

    @Column(name = "PARENTTABLE_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<ChildEntity06> childs;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<ChildEntity06> getChilds()
    {
        return childs;
    }

    public void setChilds(Set<ChildEntity06> childs)
    {
        this.childs = new HashSet(childs);
    }
}
