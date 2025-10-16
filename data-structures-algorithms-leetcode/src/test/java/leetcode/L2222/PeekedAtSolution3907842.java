package leetcode.L2222;

/// - [peeked at solution](https://leetcode.com/problems/number-of-ways-to-select-buildings/solutions/3907842/easy-recursion-memoization/?envType=problem-list-v2&envId=dynamic-programming/)
class PeekedAtSolution3907842
{
    long numberOfWays(String s)
    {
        Long[][][] memo = new Long[s.length()][3][4];
        return numberOfWays(s, '2', 0, 0, memo);
    }

    long numberOfWays(String s, char ch, int i, int count, Long[][][] memo)
    {
        if (count == 3)
        {
            return 1;
        }
        if (i >= s.length())
        {
            return 0;
        }
        if (memo[i][ch - '0'][count] != null)
        {
            return memo[i][ch - '0'][count];
        }
        long notPick = numberOfWays(s, ch, i + 1, count, memo);
        long pick = 0;
        if (s.charAt(i) != ch)
        {
            pick = numberOfWays(s, s.charAt(i), i + 1, count + 1, memo);
        }
        return memo[i][ch - '0'][count] = pick + notPick;
    }
}