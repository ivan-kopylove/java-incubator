package leetcode.a47b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MySolution_61_testsPassed_MemoryLimit
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> line1map = new HashMap<>();
        Map<Integer, Integer> line2map = new HashMap<>();
        int current = r.read();

        while ('\n' != current)
        {
            line1map.computeIfAbsent(current, integer -> integer + 1);
            line1map.computeIfPresent(current, (a, b) -> 1);
            current = r.read();
        }

        current = r.read();
        while (-1 != current)
        {
            line2map.computeIfAbsent(current, integer -> integer + 1);
            line2map.computeIfPresent(current, (a, b) -> 1);
            current = r.read();
            if(current == '\n')
            {
                break;
            }
        }


        System.out.println(line1map.equals(line2map) ? 1 : 0);
    }
}

