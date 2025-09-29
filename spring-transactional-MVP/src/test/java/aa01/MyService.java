// com.example.MyService.java
package aa01;

import org.springframework.transaction.annotation.Transactional;

import static java.util.UUID.randomUUID;

@Transactional
 class MyService
{
     String generateUuid(int someInt) {
        return randomUUID().toString();
    }
}