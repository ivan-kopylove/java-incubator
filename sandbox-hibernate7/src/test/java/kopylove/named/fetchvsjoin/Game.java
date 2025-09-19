package kopylove.named.fetchvsjoin;

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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
