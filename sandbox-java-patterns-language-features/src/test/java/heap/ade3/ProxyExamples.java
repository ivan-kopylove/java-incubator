package heap.ade3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProxyExamples
{
    @Test
    void run()
    {
        Map<String, String> proxyInstance = (Map<String, String>) Proxy.newProxyInstance(ProxyExamples.class.getClassLoader(),
                                                                                         new Class[]{Map.class},
                                                                                         new DynamicInvocationHandler());

        String put = proxyInstance.put("hello", "world");
        assertEquals("hello world", put);
    }
}
