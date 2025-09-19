package com.github.ivan.kopylove.sandbox.persistence.entities.a;




@Embeddable
class TicketDetails
{
    @Embedded
    private GenericProperties genericProperties;

    public GenericProperties getGenericProperties()
    {
        return genericProperties;
    }

    public void setGenericProperties(GenericProperties genericProperties)
    {
        this.genericProperties = genericProperties;
    }
}
