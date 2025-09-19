package kopylove.named.generatedvalue.sequence;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CAR")
class Car
{
    @Id
    @GeneratedValue(generator = "carSeqGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "carSeqGenerator", sequenceName = "CAR_SEQ", allocationSize = 1)
    @Column(name = "CAR_KEY")
    private int key;

    @Column(name = "CAR_NAME")
    private String name;

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
