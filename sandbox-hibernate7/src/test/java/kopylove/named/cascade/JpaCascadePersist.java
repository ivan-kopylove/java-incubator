package kopylove.named.cascade;

import kopylove.heap.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/// [...](https://www.baeldung.com/jpa-cascade-types)
class JpaCascadePersist
{
    @Test
    void whenParentSavedThenChildSaved()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        PersonEntity person = new PersonEntity();
        person.setName("devender");
        AddressEntity address = new AddressEntity();
        address.setPerson(person);
        person.setAddresses(Collections.singletonList(address));

        entityManager.persist(person);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void whenParentRemovedThenChildRemoved()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        PersonEntity person = new PersonEntity();
        person.setName("devender");
        AddressEntity address = new AddressEntity();
        address.setPerson(person);

        person.setAddresses(Collections.singletonList(address));

        entityManager.persist(person);
        int id = person.getId();
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        PersonEntity personEntity = entityManager.find(PersonEntity.class, id);

        entityManager.remove(personEntity);
        entityManager.getTransaction().commit(); //also deletes addresses
        entityManager.close();
    }

    @Test
    void a()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        PersonEntity person = new PersonEntity();
        person.setName("some");
        AddressEntity address = new AddressEntity();
        address.setPerson(person);

        person.setAddresses(Collections.singletonList(address));

        entityManager.persist(person);
        int id = person.getId();
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        PersonEntity personEntity = entityManager.find(PersonEntity.class, id);

        personEntity.getAddresses().remove(personEntity.getAddresses().get(0));

        entityManager.getTransaction().commit(); //also deletes addresses
        entityManager.close();
    }

    @Test
    void whenParentSavedThenMerged()
    {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        int addressId;
        PersonEntity person = new PersonEntity();
        AddressEntity address = new AddressEntity();
        person.setAddresses(Collections.singletonList(address));
        address.setPerson(person);
        entityManager.persist(person);

        addressId = address.getId();

        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();

        AddressEntity savedAddressEntity = entityManager.find(AddressEntity.class, addressId);
        PersonEntity savedPersonEntity = savedAddressEntity.getPerson();
        savedPersonEntity.setName("devender kumar");
        savedAddressEntity.setHouseNumber(24);

        entityManager.merge(savedPersonEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
