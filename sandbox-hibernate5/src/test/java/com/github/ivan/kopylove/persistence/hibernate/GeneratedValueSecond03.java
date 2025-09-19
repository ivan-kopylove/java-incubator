package com.github.ivan.kopylove.persistence.hibernate;

import jakarta.persistence.GeneratedValue;

import javax.persistence.Id;

/// drop sequence if exists MyGeneratorName
@Entity
class GeneratedValueSecond03
{
    @Id
    @GeneratedValue
    private long key;

    public long getKey()
    {
        return key;
    }
}
