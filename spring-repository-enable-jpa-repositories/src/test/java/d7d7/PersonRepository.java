package d7d7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface PersonRepository extends JpaRepository<Person, Integer>
{
	List<Person> findByFirstName(String firstName);
	List<Person> findByLastName(String lastName);
	Person findBySsn(String ssn);
}