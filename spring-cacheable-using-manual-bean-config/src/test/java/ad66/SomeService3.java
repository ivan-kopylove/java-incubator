// com.example.SomeService3.java
package ad66;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import static java.util.UUID.randomUUID;

class SomeService3
{
    @CacheEvict("myCache3")
    void evictMyCache(int someInt) {
    }

    @CacheEvict("myCache3")
    void evictMyCache() {
    }
    @CacheEvict(value = "myCache3", allEntries = true)
    void evictAllEntries() {
    }

    @Cacheable("myCache3")
    String associateMyArg(int someInt) {
        return randomUUID().toString();
    }
}