package d7d7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
 class MyService
{
    private MyRepository myRepository;
    private PersonRepository personRepository;

     MyService(MyRepository myRepository, PersonRepository personRepository)
    {
        this.myRepository = myRepository;
        this.personRepository = personRepository;
    }

    void bar()
    {
        Person p = new Person();
        personRepository.save(p);
    }
}
