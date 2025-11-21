// com.example.AppConfig3.java
package c56c;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching // why Spring doesn't throw an exception for method marked @Cacheable when cache is not enabled?
@Configuration
class AppConfig3
{
    @Bean
    SomeService3 myService()
    {
        return new SomeService3();
    }

    @Bean
    CacheManager cacheManager() // last time I deleted this method and ...
    {
        // last time I renamed the cache name and ...
        // there are no-args contructor - what does it do instead of specifying cache names?
        return new ConcurrentMapCacheManager("myCache3");
    }
}