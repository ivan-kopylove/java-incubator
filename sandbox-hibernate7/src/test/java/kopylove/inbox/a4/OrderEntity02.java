package kopylove.inbox.a4;



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

    public UserEntity01 getUser()
    {
        return user;
    }

    public void setUser(UserEntity01 user)
    {
        this.user = user;
    }

    public long getId()
    {
        return id;
    }
}
