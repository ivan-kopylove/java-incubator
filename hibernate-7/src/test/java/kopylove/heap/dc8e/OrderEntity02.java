package kopylove.heap.dc8e;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
class OrderEntity02
{
    @Id
    @GeneratedValue(generator = "itemSeqGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "itemSeqGenerator", sequenceName = "ITEM_SEQ", allocationSize = 1)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity01 user;

    UserEntity01 getUser()
    {
        return user;
    }

    void setUser(UserEntity01 user)
    {
        this.user = user;
    }

    long getId()
    {
        return id;
    }
}
