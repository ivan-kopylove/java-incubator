package kopylove.named.criteriaJoin;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
class PropertyValue
{
    @Column(name = "PROPERTIES_VALUE")
    private String value;

    String getValue()
    {
        return value;
    }

    void setValue(String value)
    {
        this.value = value;
    }
}
