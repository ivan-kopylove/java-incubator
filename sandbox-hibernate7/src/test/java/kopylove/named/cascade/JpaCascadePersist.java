package kopylove.named.cascade;

import jakarta.persistence.EntityManager;
import kopylove.heap.e70a.EntityManagerManual;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/// [...](https://www.baeldung.com/jpa-cascade-types)
class JpaCascadePersist extends EntityManagerManual
{
    @Test
    void whenParentSavedThenChildSaved()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        PersonEntity01 person = new PersonEntity01();
        person.setName("devender");
        AddressEntity01 address = new AddressEntity01();
        address.setPerson(person);
        person.setAddresses(Collections.singletonList(address));

        entityManager.persist(person);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void whenParentRemovedThenChildRemoved()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        PersonEntity01 person = new PersonEntity01();
        person.setName("devender");
        AddressEntity01 address = new AddressEntity01();
        address.setPerson(person);

        person.setAddresses(Collections.singletonList(address));

        entityManager.persist(person);
        int id = person.getId();
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        PersonEntity01 personEntity = entityManager.find(PersonEntity01.class, id);

        entityManager.remove(personEntity);
        entityManager.getTransaction().commit(); //also deletes addresses
        entityManager.close();
    }

    @Test
    void a()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        PersonEntity01 person = new PersonEntity01();
        person.setName("some");
        AddressEntity01 address = new AddressEntity01();
        address.setPerson(person);

        person.setAddresses(Collections.singletonList(address));

        entityManager.persist(person);
        int id = person.getId();
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        PersonEntity01 personEntity = entityManager.find(PersonEntity01.class, id);

        personEntity.getAddresses().remove(personEntity.getAddresses().get(0));

        entityManager.getTransaction().commit(); //also deletes addresses
        entityManager.close();
    }

    @Test
    void whenParentSavedThenMerged()
    {
        EntityManager entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        int addressId;
        PersonEntity01 person = new PersonEntity01();
        AddressEntity01 address = new AddressEntity01();
        person.setAddresses(Collections.singletonList(address));
        address.setPerson(person);
        entityManager.persist(person);

        addressId = address.getId();

        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = super.getEntityManager();
        entityManager.getTransaction().begin();

        AddressEntity01 savedAddressEntity = entityManager.find(AddressEntity01.class, addressId);
        PersonEntity01 savedPersonEntity = savedAddressEntity.getPerson();
        savedPersonEntity.setName("devender kumar");
        savedAddressEntity.setHouseNumber(24);

        entityManager.merge(savedPersonEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
