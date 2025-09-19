package kopylove.heap.e977;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_E977")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // Constructors, getters, and setters
    public User() {}

    public User(String name)
    {
        this.name = name;
    }

    // Getters and setters
    public Long getId() {return id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}