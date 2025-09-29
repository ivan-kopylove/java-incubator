// com.example.MyTransactionalService.java
package d7d6;

import org.springframework.transaction.annotation.Transactional;

class MyService
{
     void foo() {}
}

@Transactional
class MyTransactionalService
{
    void foo() {}
}