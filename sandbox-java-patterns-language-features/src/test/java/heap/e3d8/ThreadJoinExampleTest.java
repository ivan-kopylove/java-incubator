package heap.e3d8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @see <a href="https://ivan-kopylove.github.io/e3d8216e-2c3d-4b8a-a46d-3aa16d7dc24">blog</a>
 * @see <a href="obsidian://search/?vault=notes&query=e3d8216e-2c3d-4b8a-a46d-3aa16d7dc24">obsidian</a>
 */
class ThreadJoinExampleTest
{
        @Test
        @DisplayName(".join operation blocks the execution")
        void should_print_one_by_one_ascending() throws InterruptedException
        {
            for(int i = 0; i < 10; i++)
            {
                int a = i;
                Thread thread = new Thread(() -> {
                    System.out.println(a);
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                });
//                thread.join(); // try different combinations of comment-uncomment
                thread.start();
//                thread.join(); // try different combinations of comment-uncomment
            }

            System.out.println("main thread");
    }
}