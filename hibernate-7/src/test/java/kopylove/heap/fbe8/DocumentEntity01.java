package kopylove.heap.fbe8;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

@Entity
class DocumentEntity01
{
    @Id
    @Column(name = "DOCUMENT_KEY")
    private int key;

    @Column(name = "DOCUMENT_NAME")
    private String name;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "DOCUMENT_USERS_LOGIN", referencedColumnName = "USERS_LOGIN"), @JoinColumn(name = "DOCUMENT_USERS_SSN", referencedColumnName = "USERS_SSN")})
    private UserEntity02 user;

    int getKey()
    {
        return key;
    }

    void setKey(int key)
    {
        this.key = key;
    }

    String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name = name;
    }

    UserEntity02 getUser()
    {
        return user;
    }

    void setUser(UserEntity02 user)
    {
        this.user = user;
    }
}
