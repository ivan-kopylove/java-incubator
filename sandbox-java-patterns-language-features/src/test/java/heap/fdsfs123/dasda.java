package heap.fdsfs123;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class dasda
{

    @Test
    @DisplayName("How many balancing strategies are in the HashMap?")
    void should_do_something_when_condition()
    {
        // given
        HashMap<Key, String> map = new HashMap<>(4, 0.75f);

        // Add elements that will cause collisions
        for (int i = 0; i < 20; i++)
        {
            // These keys will have the same hash but are not equal
            map.put(new Key(i), "Value " + i);
        }

        System.out.println("HashMap size: " + map.size());
        System.out.println("HashMap contents: " + map);


    }

     class Key
    {
        int id;

        Key(int id)
        {
            this.id = id;
        }

        @Override
        public int hashCode()
        {
            // Force collisions for demonstration
            // How can I navigate to a place where this collision is visible?
            return id % 5; // Only 5 possible hash values
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            Key key = (Key) obj;
            return id == key.id;
        }

        @Override
        public String toString()
        {
            return "Key" + id;
        }
    }
}
