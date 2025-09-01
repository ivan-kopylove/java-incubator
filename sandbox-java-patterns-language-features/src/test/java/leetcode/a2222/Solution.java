package leetcode.a2222;

class Solution
{
    public long numberOfWays(String s)
    {

            return dfs(new StringBuilder(), 0, s);

    }

    int dfs(StringBuilder current, int i, String s)
    {
        if (current.length() == 3)
        {
            return 1;
        }

        if ( i >= s.length())
        {
            return 0;
        }

        int counter = 0;
        char currentChar = s.charAt(i);
        if (current.length() == 0)
        {
            current.append(currentChar);
            counter += dfs(current, i + 1, s);
            current.deleteCharAt(current.length() - 1);
        }
        else if (current.length() > 0)
        {
            if (current.charAt(current.length() - 1) == '1' && currentChar == '0')
            {
                current.append(currentChar);
                counter += dfs(current, i + 1, s);
                current.deleteCharAt(current.length() - 1);
            }
            else if (current.charAt(current.length() - 1) == '0' && currentChar == '1')
            {
                current.append(currentChar);
                counter += dfs(current, i + 1, s);
                current.deleteCharAt(current.length() - 1);
            }
        }

        counter += dfs(current, i + 1, s);

        return counter;
    }
}