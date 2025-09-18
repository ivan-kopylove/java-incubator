package com.github.ivan.kopylove.persistence.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
