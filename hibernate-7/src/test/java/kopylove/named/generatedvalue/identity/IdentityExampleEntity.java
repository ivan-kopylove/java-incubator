package kopylove.named.generatedvalue.identity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class IdentityExampleEntity
{
    /// The GenerationType.IDENTITY is the easiest to use but not the best one from a performance PoV.
    ///
    /// It relies on an auto-incremented database column and lets the database generate a new value with each insert operation.
    @Id
    @Column(name = "IDENTITY_EXAMPLE_PK")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    int getId()
    {
        return id;
    }
}
