// com.example.AppConfig2.java
package b5aa;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching // why Spring doesn't throw an exception for method marked @Cacheable when cache is not enabled?
@Configuration
public class AppConfig2
{
    @Bean
    public MyCacheableService2 myService() {
        return new MyCacheableService2();
    }

    @Bean
    public CacheManager cacheManager() // last time I deleted this method and ...
    {
        // last time I renamed the cache name and ...
        // there are no-args contructor - what does it do instead of specifying cache names?
        return new ConcurrentMapCacheManager("myCache2");
    }
}