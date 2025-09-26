package leetcode.L241;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/// - [19 / 25 testcases passed](https://leetcode.com/problems/different-ways-to-add-parentheses/submissions/1764655146/)
///
/// - [searchable problem definition](https://google.com/search?q=leetcode%20241)
/// - [garden](https://ivan-kopylove.github.io/leetcode/190b)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+leetcode+241)
/// - [obsidian](obsidian://search?query=leetcode%20241)
class MySolution_19_25_casesPassed
{
    public List<Integer> diffWaysToCompute(String expression)
    {

        Map<String, Integer> memo = new HashMap<>();

        List<Integer> collector = new LinkedList();
        dfs(expression, collector, memo);
        return collector;
    }

    void dfs(String expression, List<Integer> collector, Map<String, Integer> memo)
    {

        if (!(expression.contains("+") || expression.contains("-") || expression.contains("*")))
        {
            if (expression.startsWith("m"))
            {
                int negative = Integer.valueOf(expression.substring(1)) * -1;
                collector.add(negative);
            }
            else
            {
                int pos = Integer.valueOf(expression);
                collector.add(pos);
            }

            return;
        }

        if (memo.get(expression) != null)
        {
            return;
        }

        memo.put(expression, 1);


        for (int i = 0; i < expression.length(); i++)
        {
            char current = expression.charAt(i);

            if (!Character.isDigit(current) && current != 'm')
            {
                int l = i - 1;
                int r = i + 1;

                String left = "";
                String right = "";

                while (l >= 0 && Character.isDigit(expression.charAt(l)))
                {

                    left = expression.charAt(l) + left;
                    l--;
                }

                int lMultiplier = 1;

                if (l >= 0 && expression.charAt(l) == 'm')
                {
                    lMultiplier = -1;
                    l--;
                }


                int rMultiplier = 1;
                if (expression.charAt(r) == 'm')
                {
                    rMultiplier = -1;
                    r++;
                }

                while (r < expression.length() && Character.isDigit(expression.charAt(r)))
                {
                    right = right + expression.charAt(r);
                    r++;
                }


                int operandL = Integer.valueOf(left) * lMultiplier;
                int operandR = Integer.valueOf(right) * rMultiplier;

                int evaluated = 0;
                if (current == '-')
                {
                    evaluated = operandL - operandR;
                }
                else if (current == '*')
                {
                    evaluated = operandL * operandR;
                }
                else if (current == '+')
                {
                    evaluated = operandL + operandR;
                }

                String newExpr = null;
                if (evaluated < 0)
                {
                    int abs = Math.abs(evaluated);

                    newExpr = expression.substring(0, l + 1) + "m" + abs + expression.substring(r, expression.length());
                }
                else
                {
                    newExpr = expression.substring(0, l + 1) + evaluated + expression.substring(r, expression.length());
                }


                dfs(newExpr, collector, memo);
            }
        }
    }
}
