package com.github.ivan.kopylove.persistence.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
class GeneratedValueUuid2
{
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "uuid2")
    private String key;

    public String getKey()
    {
        return key;
    }
}
