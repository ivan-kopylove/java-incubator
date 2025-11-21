// com.example.SomeService4.java
package cb8c;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static java.util.UUID.randomUUID;

@Service
class SomeService4
{
    @Cacheable(value = "myCache")
    String generateUuid(int someInt)
    {
        return randomUUID().toString();
    }
}