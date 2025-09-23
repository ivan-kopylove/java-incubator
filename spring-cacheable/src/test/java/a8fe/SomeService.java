// com.example.SomeService.java
package a8fe;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static java.util.UUID.randomUUID;

@Service
public class SomeService
{
    @Cacheable(value = "myCache")
    public String generateUuid(int someInt) {
        return randomUUID().toString();
    }
}