// com.example.MyCacheableService2.java
package b5aa;

import org.springframework.cache.annotation.Cacheable;

import static java.util.UUID.randomUUID;

class MyCacheableService2
{
    @Cacheable(value = "myCache2")
    String generateUuid(int someInt)
    {
        return randomUUID().toString();
    }
}