package heap.a50a;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Add_Offer
{

    private boolean offerCalled = false;

    @Test
    public void testAddCallsOffer() {
        // a spy to verify method delegation
        PriorityQueue<Integer> queue = new PriorityQueue<>() {
            @Override
            public boolean offer(Integer e) {
                offerCalled = true;
                return super.offer(e);
            }

            @Override
            public boolean add(Integer e) {
                offerCalled = false;
                return super.add(e); // open add implementation and pronounce a pattern name out of loud
            }
        };

        // when
        queue.add(100);

        // then
        assertThat(offerCalled, is(true));
    }
}