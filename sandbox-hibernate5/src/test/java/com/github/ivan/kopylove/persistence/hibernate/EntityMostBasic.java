package com.github.ivan.kopylove.persistence.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/// If no @Table and @Column are specified, Hibernate generates following schema:
/// create table MinimalEntity (key bigint not null, primary key (key))
@Entity
class EntityMostBasic
{
    @Id
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
