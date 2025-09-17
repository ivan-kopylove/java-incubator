package leetcode.b282;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/// [problem definition](https://contest.yandex.ru/contest/8458/problems/D/)
public class PeekedAtSolutionBaos
{
    private static int                  n   = 0;
    private static BufferedOutputStream out = new BufferedOutputStream(System.out, 64 * 1024);
    private static byte[]               chars;

    public static void main(String[] args) throws Exception
    {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String line = r.readLine();
        n = Integer.parseInt(line);

        chars = new byte[n * 2 + 1]; // what does plus one give?
        chars[chars.length - 1] = '\n';

        dfs(0, 0, n);
        out.flush();
    }

    private static void dfs(int left, int right, int n) throws IOException
    {
        if (left == n && right == n)
        {
            out.write(chars);
            return;
        }

        if (left < n)
        {
            chars[left + right] = '(';
            dfs(left + 1, right, n);
        }

        if (right < left)
        {
            chars[left + right] = ')';
            dfs(left, right + 1, n);
        }
    }
}

