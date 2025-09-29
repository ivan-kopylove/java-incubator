// com.example.MyTransactionalService.java
package aa01;

import org.springframework.transaction.annotation.Transactional;

import static java.util.UUID.randomUUID;


class MyService
{
     void foo() {}
}

@Transactional
class MyTransactionalService
{
    void foo() {}
}