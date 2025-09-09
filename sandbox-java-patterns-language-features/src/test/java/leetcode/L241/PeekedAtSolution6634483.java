package leetcode.L241;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/// - [peeked at solution](https://leetcode.com/problems/different-ways-to-add-parentheses/solutions/6634483/master-expression-evaluation-unlock-all-possible-results-from-a-math-string/)
/// - [problem definition](https://google.com/search?q=leetcode%20241)
/// - [garden](https://ivan-kopylove.github.io/leetcode/190b)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+241)
/// - [my submission](https://leetcode.com/problems/different-ways-to-add-parentheses/submissions/1764655146/)
/// - [obsidian](obsidian://search?query=leetcode%20241)
class PeekedAtSolution6634483
{
    public List<Integer> diffWaysToCompute(String expression)
    {
        return dfs(expression);
    }

    List<Integer> dfs(String expression)
    {
        try
        {
            return Collections.singletonList(Integer.parseInt(expression));
        }
        catch (NumberFormatException e)
        {

        }

        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++)
        {
            char current = expression.charAt(i);

            if (current == '+' || current == '-' || current == '*')
            {
                List<Integer> lefts = dfs(expression.substring(0, i));
                List<Integer> rights = dfs(expression.substring(i + 1));

                for (int left : lefts)
                {
                    for (int right : rights)
                    {
                        if (current == '+')
                        {
                            result.add(left + right);
                        }
                        else if (current == '-')
                        {
                            result.add(left - right);
                        }
                        else if (current == '*')
                        {
                            result.add(left * right);
                        }
                    }
                }
            }
        }

        return result;
    }
}