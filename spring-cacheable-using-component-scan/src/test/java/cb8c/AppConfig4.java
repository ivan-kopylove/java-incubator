// com.example.AppConfig4.java
package cb8c;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableCaching // why Spring doesn't throw an exception for method marked @Cacheable when cache is not enabled?
@Configuration
@ComponentScan(basePackages = {"cb8c"})
public class AppConfig4
{

    @Bean
    public CacheManager cacheManager() // last time I deleted this method and ...
    {
        return new ConcurrentMapCacheManager("myCache");// last time I renamed the cache name and ...
    }
}