package leetcode.L990;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/// 179 / 181 testcases passed
///
/// - [searchable problem definition](https://google.com/search?q=leetcode%20990)
/// - [garden](https://ivan-kopylove.github.io/leetcode/88a6)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+leetcode+990)
/// - [obsidian](obsidian://search?query=leetcode%20990)
class MySolution_179_181_casesPassed
{
    private static void enrichTransitive(Map<Character, Set<Character>> eq, char left, char right)
    {
        Set<Character> Acharacters = eq.computeIfPresent(left, (k, v) -> {
            for (char c : v)
            {
                enrich(eq, c, right);
                enrich(eq, right, c);
            }

            return v;
        });
    }

    private static void enrich(Map<Character, Set<Character>> eq, char left, char right)
    {
        eq.computeIfPresent(left, (x, y) -> {
            y.add(right);
            return y;
        });
        eq.computeIfAbsent(left, x -> {
            HashSet<Character> objects = new HashSet<>();
            objects.add(right);
            return objects;
        });
    }

    public boolean equationsPossible(String[] equations)
    {
        Arrays.sort(equations, (a, b) -> b.charAt(1) - a.charAt(1));

        Map<Character, Set<Character>> eq = new HashMap<>();
        Map<Character, Set<Character>> neq = new HashMap<>();

        for (int i = 0; i < equations.length; i++)
        {

            char left = equations[i].charAt(0);
            char op = equations[i].charAt(1);

            char right = equations[i].charAt(3);


            if (op == '=')
            {
                enrich(eq, left, right);
                enrich(eq, right, left);

                enrichTransitive(eq, left, right);
                enrichTransitive(eq, right, left);
            }
            else if (op == '!')
            {
                if (left == right)
                {
                    return false;
                }

                if (eq.get(left) != null && eq.get(left).stream().anyMatch(el -> el == right))
                {
                    return false;
                }
            }
        }

        return true;
    }
}