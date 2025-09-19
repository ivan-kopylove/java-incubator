package com.github.ivan.kopylove.persistence.hibernate;


import jakarta.persistence.GeneratedValue;


/// drop sequence if exists MyGeneratorName
@Entity
class GeneratedValueMostBasicSecond
{
    @Id
    @GeneratedValue
    private long key;

    public long getKey()
    {
        return key;
    }
}
