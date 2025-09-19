package leetcode.L2571;

/// - [searchable problem definition](https://google.com/search?q=leetcode%202571)
/// - [garden](https://ivan-kopylove.github.io/leetcode/0c78)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+2571)
/// - [obsidian](obsidian://search?query=leetcode%202571)
class MyFailedSolution
{
    public int minOperations(int n)
    {

        int low = 0;
        int high = 1;

        while (true)
        {
            low = high;
            high = high *= 2;

            if (n <= high)
            {
                break;
            }
        }

        if (n == high)
        {
            return 1;
        }

        if (n == low)
        {
            return 1;
        }

        return dfs(n, low, low, high);
    }

    int dfs(int n, int low1, int low2, int high)
    {
        if (n >= high)
        {
            return 0;
        }

        if (n <= 0)
        {
            return 0;
        }

        if (low1 <= 0 || low2 <= 0)
        {
            return 0;
        }


        int one = 1 + dfs(n - low2, low1, low2 / 2, high);
        int two = 1 + dfs(n + low1, low1 / 2, low2, high);

        return Math.min(one, two);
    }
}