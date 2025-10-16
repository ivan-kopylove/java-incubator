package kopylove.heap.e977;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class User01
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    User01() {}

    User01(String name)
    {
        this.name = name;
    }

    Long getId() {return id;}

    String getName() {return name;}

    void setName(String name) {this.name = name;}
}