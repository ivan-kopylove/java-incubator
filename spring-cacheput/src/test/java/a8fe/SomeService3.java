// com.example.SomeService3.java
package a8fe;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import static java.util.UUID.randomUUID;

public class SomeService3
{
    @CachePut("myCache3")
    public String generateUuid(int someInt) {
        return randomUUID().toString();
    }

    @Cacheable("myCache3")
    public String generateUuid2(int someInt) {
        return randomUUID().toString();
    }


}