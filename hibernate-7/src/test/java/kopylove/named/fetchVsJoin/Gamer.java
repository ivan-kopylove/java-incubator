package kopylove.named.fetchVsJoin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
class Gamer
{
    @Id
    private int id;

    @Column(name = "NICKNAME")
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "GAME", nullable = false)
    private Game game;

    int getId()
    {
        return id;
    }

    void setId(int id)
    {
        this.id = id;
    }

    String getNickname()
    {
        return nickname;
    }

    void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    Game getGame()
    {
        return game;
    }

    void setGame(Game game)
    {
        this.game = game;
    }
}
