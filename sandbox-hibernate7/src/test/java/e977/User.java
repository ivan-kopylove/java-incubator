package e977;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
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