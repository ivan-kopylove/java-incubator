package leetcode.a47b;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MySolution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String line1 = r.readLine();
        String line2 = r.readLine();

        /// how can this be sanity-checked before running heavy calculations?

        if(line1.length() != line2.length())
        {
            System.out.println(0);
        }

        /// count each char and compare
        /// - length
        /// - start from 1
        /// - start from 2

        Map<Integer, List<Integer>> line1map = line1.chars().mapToObj(val -> (Integer) val).collect(Collectors.groupingBy(val -> val));
        Map<Integer, List<Integer>> line2map = line2.chars().mapToObj(val -> (Integer) val).collect(Collectors.groupingBy(val -> val));


        System.out.println(line1map.equals(line2map) ? 1 : 0);
    }
}

