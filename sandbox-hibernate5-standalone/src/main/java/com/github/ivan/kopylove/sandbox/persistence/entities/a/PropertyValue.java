package com.github.ivan.kopylove.sandbox.persistence.entities.a;




@Embeddable
class PropertyValue
{
    @Column(name = "PROPERTIES_VALUE")
    private String value;

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
