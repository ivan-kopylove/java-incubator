package com.github.ivan.kopylove.persistence.hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GeneratedValueUuid
{
    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "uuid")
    private String key;

    public String getKey()
    {
        return key;
    }
}
