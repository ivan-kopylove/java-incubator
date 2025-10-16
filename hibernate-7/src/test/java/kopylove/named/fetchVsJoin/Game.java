package kopylove.named.fetchVsJoin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class Game
{
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "TITLE")
    private String title;

    int getId()
    {
        return id;
    }

    void setId(int id)
    {
        this.id = id;
    }

    String getTitle()
    {
        return title;
    }

    void setTitle(String title)
    {
        this.title = title;
    }
}
