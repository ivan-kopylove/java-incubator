// com.example.SomeService2.java
package a8fe;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static java.util.UUID.randomUUID;

public class SomeService2
{
    @Cacheable(value = "myCache2")
    public String generateUuid(int someInt) {
        return randomUUID().toString();
    }
}