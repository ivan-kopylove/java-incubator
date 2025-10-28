package heap.jfkldsjfs2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RecursiveTaskExample {

    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        ForkJoinPool commonPool = ForkJoinPool.commonPool();

        // when
        Integer result = commonPool.invoke(new CustomRecursiveTask(new int[] {5, 8, 12, 20, 25}));

        // then
        assertThat(result, equalTo(570));
    }

}

class CustomRecursiveTask extends RecursiveTask<Integer>
{
    private int[] arr;
    private static final int THRESHOLD = 20;

     CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.length > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                               .stream()
                               .mapToInt(ForkJoinTask::join)
                               .sum();
        } else {
            return processing(arr);
        }
    }

    private Collection<CustomRecursiveTask> createSubtasks() {
        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, 0, arr.length / 2)));
        dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
        return dividedTasks;
    }

    private Integer processing(int[] arr) {
        return Arrays.stream(arr)
                     .filter(a -> a > 10 && a < 27)
                     .map(a -> a * 10)
                     .sum();
    }
}