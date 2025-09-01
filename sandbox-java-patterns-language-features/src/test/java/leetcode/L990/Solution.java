package leetcode.L990;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution
{
    public boolean equationsPossible(String[] equations)
    {
        Arrays.sort(equations, (a, b) -> b.charAt(1) - a.charAt(1));

        Map<Character, Set<Character>> eq = new HashMap<>();
        Map<Character, Set<Character>> neq = new HashMap<>();

        for (int i = 0; i < equations.length; i++)
        {

            char a = equations[i].charAt(0);
            char op = equations[i].charAt(1);

            char b = equations[i].charAt(3);


            if (op == '=')
            {
                enrich(eq, a, b);
                enrich(eq, b, a);

                enrichTransitive(eq, a, b);
                enrichTransitive(eq, b, a);


            }
            else if (op == '!')
            {
                if (a == b)
                {
                    return false;
                }

                if(eq.get(a) != null && eq.get(a).stream().anyMatch(el -> el ==b))
                {
                    return false;
                }

            }
        }

        return true;
    }

    private static void enrichTransitive(Map<Character, Set<Character>> eq, char a, char b)
    {
        Set<Character> Acharacters = eq.computeIfPresent(a, (k, v) -> {
            for (char c : v)
            {
                enrich(eq, c, b);
                enrich(eq, b, c);
            }

            return v;
        });
    }

    private static void enrich(Map<Character, Set<Character>> eq, char a, char b)
    {
        eq.computeIfPresent(a, (x, y) -> {
            y.add(b);
            return y;
        });
        eq.computeIfAbsent(a, x -> {
            HashSet<Character> objects = new HashSet<>();
            objects.add(b);
            return objects;
        });
    }
}