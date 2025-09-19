package com.github.ivan.kopylove.persistence.hibernate;


import jakarta.persistence.GeneratedValue;


/// drop sequence if exists MyGeneratorName
@Entity
class GeneratedValueCustomName
{
    @Id
    @GeneratedValue(generator = "MyGeneratorName")
    private long key;

    public long getKey()
    {
        return key;
    }

    public void setKey(long key)
    {
        this.key = key;
    }
}
