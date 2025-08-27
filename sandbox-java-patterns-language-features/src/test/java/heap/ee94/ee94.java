package heap.ee94;

import org.junit.jupiter.api.Test;

@SuppressWarnings("ALL")
public class ee94 {

    /**
     * what will be printed?
     * what kind of number 32 is?
     * what if there were another number?
     */
    @Test
    void what_is_the_point_of_this() {
        int n = 32;
        System.out.println((n & (n - 1)) == 0);
    }
}
