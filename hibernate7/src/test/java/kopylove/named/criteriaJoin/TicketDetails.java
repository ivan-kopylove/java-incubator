package kopylove.named.criteriaJoin;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

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
