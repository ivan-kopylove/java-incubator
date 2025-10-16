// com.example.SomeService3.java
package c56c;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import static java.util.UUID.randomUUID;

class SomeService3
{
    @CachePut("myCache3")
    String generateUuid(int someInt) {
        return randomUUID().toString();
    }

    @Cacheable("myCache3")
    String generateUuid2(int someInt) {
        return randomUUID().toString();
    }


}