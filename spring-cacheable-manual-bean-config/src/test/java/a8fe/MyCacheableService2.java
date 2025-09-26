// com.example.MyCacheableService2.java
package a8fe;

import org.springframework.cache.annotation.Cacheable;

import static java.util.UUID.randomUUID;

public class MyCacheableService2
{
    @Cacheable(value = "myCache2")
    public String generateUuid(int someInt) {
        return randomUUID().toString();
    }
}