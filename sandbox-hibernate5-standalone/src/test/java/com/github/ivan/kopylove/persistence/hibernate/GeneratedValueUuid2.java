package com.github.ivan.kopylove.persistence.hibernate;

import org.hibernate.annotations.GenericGenerator;


import jakarta.persistence.GeneratedValue;


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
