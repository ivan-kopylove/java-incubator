// com.example.SomeService.java
package das;

import org.springframework.stereotype.Service;

@Service
public class SomeService
{
    public String getMessage() {
        return "Hello from SomeService!";
    }
}