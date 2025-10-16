package kopylove.named.criteriaJoin;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
class TicketDetails
{
    @Embedded
    private GenericProperties genericProperties;

    GenericProperties getGenericProperties()
    {
        return genericProperties;
    }

    void setGenericProperties(GenericProperties genericProperties)
    {
        this.genericProperties = genericProperties;
    }
}
