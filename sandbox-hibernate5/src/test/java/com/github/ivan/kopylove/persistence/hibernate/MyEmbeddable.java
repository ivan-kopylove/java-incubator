package com.github.ivan.kopylove.persistence.hibernate;




@Embeddable
class MyEmbeddable
{
    @Column(name = "PARENTTABLE_NAME")
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
