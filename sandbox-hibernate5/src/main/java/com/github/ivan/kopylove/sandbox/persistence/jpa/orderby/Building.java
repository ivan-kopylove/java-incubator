package com.github.ivan.kopylove.sandbox.persistence.jpa.orderby;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;

import java.util.List;

@Entity
class Building
{
    @Id
    private long         key;
    @ElementCollection
    @OrderBy
    private List<String> phoneNumbers;

    public long getKey()
    {
        return key;
    }

    public void setKey(long key)
    {
        this.key = key;
    }

    public List<String> getPhoneNumbers()
    {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers)
    {
        this.phoneNumbers = phoneNumbers;
    }
}
