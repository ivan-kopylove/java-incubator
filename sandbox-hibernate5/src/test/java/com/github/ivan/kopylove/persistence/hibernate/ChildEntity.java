package com.github.ivan.kopylove.persistence.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
class ChildEntity
{
    @Id
    @Column(name = "CHILDTABLE_KEY", unique = true, nullable = false)
    private Integer key;

    @Column(name = "CHILDTABLE_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CHILDTABLE_PARENT_KEY", nullable = false)
    private ParentEntity parent;

    public Integer getKey()
    {
        return key;
    }

    public void setKey(Integer key)
    {
        this.key = key;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ParentEntity getParent()
    {
        return parent;
    }

    public void setParent(ParentEntity parent)
    {
        this.parent = parent;
    }
}
