package leetcode.L990;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//180 / 181 testcases passed
class MySolution_180_181_casesPassed
{
    private static void enrichTransitive(Map<Character, Set<Character>> eq, char left, char right)
    {
        eq.computeIfPresent(left, (k, v) -> {
            for (char c : v)
            {
                enrich(eq, c, right);
                enrich(eq, right, c);
            }

            return v;
        });

        Map<Character, Character> merge = new HashMap<>();

        eq.computeIfPresent(left, (k1, v1) -> {
            eq.computeIfPresent(right, (k2, v2) -> {
                for (char v1c : v1)
                {
                    for (char v2c : v2)
                    {
                        merge.put(v1c, v2c);
                        merge.put(v2c, v1c);
                    }
                }

                return v2;
            });
            return v1;
        });

        merge.forEach((k, v) -> {
            eq.computeIfPresent(k, (k1, v1) -> {
                v1.add(v);
                return v1;
            });
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

    boolean equationsPossible(String[] equations)
    {
        Arrays.sort(equations, (a, b) -> b.charAt(1) - a.charAt(1));

        Map<Character, Set<Character>> eq = new HashMap<>();

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

                if (eq.get(left) != null && eq.get(left)
                                              .stream()
                                              .anyMatch(el -> el == right))
                {
                    return false;
                }
            }
        }

        return true;
    }
}