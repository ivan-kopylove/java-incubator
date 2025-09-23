// com.example.AppConfig2.java
package a8fe;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableCaching // why Spring doesn't throw an exception for method marked @Cacheable when cache is not enabled?
@Configuration
public class AppConfig2
{
    @Bean
    public SomeService2 myService() {
        return new SomeService2();
    }

    @Bean
    public CacheManager cacheManager() // last time I deleted this method and ...
    {
        // last time I renamed the cache name and ...
        // there are no-args contructor - what does it do instead of specifying cache names?
        return new ConcurrentMapCacheManager("myCache2");
    }
}