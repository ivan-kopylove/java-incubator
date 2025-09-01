package leetcode.L990;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution
{
    public boolean equationsPossible(String[] equations)
    {
        Arrays.sort(equations, (a, b) -> b.charAt(1) - a.charAt(1));

        Map<Character, Set<Character>> eq = new HashMap<>();

        Map<Character, List<String>> ops = Arrays.stream(equations).collect(Collectors.groupingBy(el -> el.charAt(1)));

        List<String> eqStr = ops.get('=');
        List<String> neqStr = ops.get('!');

        for (int i = 0; i < eqStr.size(); i++)
        {
            char left = eqStr.get(i).charAt(0);
            char right = eqStr.get(i).charAt(3);

            enrich(eq, left, right);
            enrich(eq, right, left);
        }

        Map<Character, Set<Character>> merge = new HashMap<>();

        eq.entrySet().forEach( (v) -> {
            Set<Character> value = v.getValue();
            for(char c1 : value)
            {
                for(char c2 : value)
                {
                    enrich(merge, c1, c2);
                }
            }
        });

        eq.putAll(merge);

        for (int i = 0; i < neqStr.size(); i++)
        {
            char left = neqStr.get(i).charAt(0);
            char right = neqStr.get(i).charAt(3);

            if (left == right)
            {
                return false;
            }

            if (checkEquality(eq, left, right))
            {
                return false;
            }
            if (checkEquality(eq, right, left))
            {
                return false;
            }

        }


        return true;
    }

    private static boolean checkEquality(Map<Character, Set<Character>> eq, char left, char right)
    {
        if (eq.get(left) != null && eq.get(left).stream().anyMatch(el -> el == right))
        {
            return true;
        }
        return false;
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
}