package kopylove.heap.e977;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User1
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public User1() {}

    public User1(String name)
    {
        this.name = name;
    }

    
    public Long getId() {return id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}