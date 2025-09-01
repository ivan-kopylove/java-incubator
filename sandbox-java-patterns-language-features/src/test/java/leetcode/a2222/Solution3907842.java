package leetcode.a2222;

/**
 * @see <a href="https://leetcode.com/problems/number-of-ways-to-select-buildings/solutions/3907842/easy-recursion-memoization/?envType=problem-list-v2&envId=dynamic-programming/">6789775</a>
 * @see <a href="https://ivan-kopylove.github.io/leetcode/0c78">garden</a>
 */
class Solution3907842
{
    public long numberOfWays(String s)
    {
        Long[][][] memo = new Long[s.length()][3][4];
        return numberOfWays(s, '2', 0, 0, memo);
    }

    public long numberOfWays(String s, char ch, int si, int count, Long[][][] memo)
    {
        if (count == 3)
        {
            return 1;
        }
        if (si >= s.length())
        {
            return 0;
        }
        if (memo[si][ch - '0'][count] != null)
        {
            return memo[si][ch - '0'][count];
        }
        long notPick = numberOfWays(s, ch, si + 1, count, memo);
        long pick = 0;
        if (s.charAt(si) != ch)
        {
            pick = numberOfWays(s, s.charAt(si), si + 1, count + 1, memo);
        }
        return memo[si][ch - '0'][count] = pick + notPick;
    }
}