package leetcode.ef29;

import java.io.*;

/// - [problem definition](https://www.google.com/search?q=yandex+contest+B.+Последовательно+идущие+единицы)
/// - [garden](https://ivan-kopylove.github.io/leetcode/8d9e)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+Последовательно+идущие+единицы)
/// - [obsidian](obsidian://search?query=Последовательно идущие единицы)
public class WooHoo
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String line = r.readLine();
        if ("0".equals(line))
        {
            System.out.println("0");
            return;
        }
        line = r.readLine();

        int max = 0;
        int current = 0;

        while (line != null && !"".equals(line)) // what is redundant here?
        {
            if ("1".equals(line))
            {
                current++;
            }
            else if ("0".equals(line)) // why did I put else if?
            {
                max = Math.max(max, current);
                current = 0;
            }

            line = r.readLine();
        }

        System.out.println(max);
    }
}

