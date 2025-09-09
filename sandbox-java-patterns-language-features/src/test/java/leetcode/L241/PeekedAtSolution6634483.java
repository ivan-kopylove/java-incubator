package leetcode.L241;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/// @see <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/solutions/6634483/master-expression-evaluation-unlock-all-possible-results-from-a-math-string/">peeked at solution</a>
/// @see <a href="https://google.com/search?q=leetcode%20241">problem definition</a>
/// @see <a href="https://ivan-kopylove.github.io/leetcode/190b">garden</a>
/// @see <a href="https://github.com/search?q=user%3Aivan-kopylove+241">github</a>
/// @see <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/submissions/1764655146/">my submission</a>
/// @see <a href="obsidian://search?query=leetcode%20241">obsidian</a>
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