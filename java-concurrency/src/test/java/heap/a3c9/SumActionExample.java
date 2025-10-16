package heap.a3c9;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static java.util.stream.Collectors.toList;

/// What search engine request should I use to refresh the theory about this?
 class SumActionExample
{

    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        ForkJoinPool pool = new ForkJoinPool();
        Random random = new Random();

        List<Long> data = random
                .longs(11, 1, 5)
                .boxed()
                .collect(toList());

        System.out.println("Pool parallelism: " + pool.getParallelism());
        SumAction task = new SumAction(data);
        pool.invoke(task);
    }
}


class SumAction extends RecursiveAction {
    private static final int SEQUENTIAL_THRESHOLD = 5;

    private List<Long> data;

    SumAction(List<Long> data) {
        this.data = data;
    }

    @Override
    protected void compute() {
        if (data.size() <= SEQUENTIAL_THRESHOLD) { // base case
            long sum = computeSumDirectly();
            System.out.format("Sum of %s: %d\n", data.toString(), sum);
        }
        else
        {
            int mid = data.size() / 2;
            SumAction firstSubtask = new SumAction(data.subList(0, mid));
            SumAction secondSubtask = new SumAction(data.subList(mid, data.size()));

            firstSubtask.fork();
            secondSubtask.compute();
            firstSubtask.join();
        }
    }

    private long computeSumDirectly() {
        long sum = 0;
        for (Long l: data) {
            sum += l;
        }
        return sum;
    }
}