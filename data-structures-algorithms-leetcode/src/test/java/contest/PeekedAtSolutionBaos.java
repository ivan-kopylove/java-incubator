package contest;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/// [problem definition](https://contest.yandex.ru/contest/8458/problems/D/)
/// [searchable problem definition](https://www.google.com/search?client=ubuntu-sn&channel=fs&q=yandex+contest+%D0%B3%D0%B5%D0%BD%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D1%8F+%D1%81%D0%BA%D0%BE%D0%B1%D0%BE%D1%87%D0%BD%D1%8B%D1%85+%D0%BF%D0%BE%D1%81%D0%BB%D0%B5%D0%B4%D0%BE%D0%B2%D0%B0%D1%82%D0%B5%D0%BB%D1%8C%D0%BD%D0%BE%D1%81%D1%82%D0%B5%D0%B9)
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

