// com.example.SomeService3.java
package ad66;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import static java.util.UUID.randomUUID;

public class SomeService3
{
    @CacheEvict("myCache3")
    public void evictMyCache(int someInt) {
    }

    @CacheEvict("myCache3")
    public void evictMyCache() {
    }
    @CacheEvict(value = "myCache3", allEntries = true)
    public void evictAllEntries() {
    }

    @Cacheable("myCache3")
    public String associateMyArg(int someInt) {
        return randomUUID().toString();
    }
}