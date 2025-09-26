package leetcode.L990;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/// 181 / 181 testcases passed
///
/// - [searchable problem definition](https://google.com/search?q=leetcode%20990)
/// - [garden](https://ivan-kopylove.github.io/leetcode/88a6)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+leetcode+990)
/// - [my submission](https://leetcode.com/problems/satisfiability-of-equality-equations/submissions/1755893062/)
/// - [obsidian](obsidian://search?query=leetcode%20990)
class MySolution_181_181_casesPassed
{
    private static boolean checkEquality(Map<Character, Set<Character>> eq, char left, char right, Set<Character> visited)
    {
        if (left == right)
        {
            return false;
        }

        visited.add(left);
        Set<Character> characters = eq.get(left);
        if (characters == null)
        {
            return true;
        }
        for (char c : characters)
        {
            if (visited.contains(c))
            {
                continue;
            }

            boolean res = checkEquality(eq, c, right, visited);
            if (!res)
            {
                return res;
            }
        }

        return true;
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
        // why it doesnt make sence to sort?
        Arrays.sort(equations, (a, b) -> b.charAt(1) - a.charAt(1));

        Map<Character, Set<Character>> eq = new HashMap<>();

        Map<Character, List<String>> ops = Arrays.stream(equations).collect(Collectors.groupingBy(el -> el.charAt(1)));

        List<String> eqStr = ops.get('=');
        List<String> neqStr = ops.get('!');

        if (neqStr == null)
        {
            return true;
        }

        if (eqStr != null)
        {
            for (int i = 0; i < eqStr.size(); i++)
            {
                char left = eqStr.get(i).charAt(0);
                char right = eqStr.get(i).charAt(3);

                enrich(eq, left, right);
                enrich(eq, right, left);
            }
        }

        for (int i = 0; i < neqStr.size(); i++)
        {
            char left = neqStr.get(i).charAt(0);
            char right = neqStr.get(i).charAt(3);

            if (left == right)
            {
                return false;
            }

            if (!checkEquality(eq, right, left, new HashSet()))
            {
                return false;
            }
        }


        return true;
    }
}