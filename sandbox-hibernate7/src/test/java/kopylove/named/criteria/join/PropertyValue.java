package kopylove.named.criteria.join;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

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
