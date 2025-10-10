package leetcode.asdasd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution050
{

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else if (s.charAt(i) == ')')
            {
                if (left > 0)
                {
                    left--;
                }
                else
                {
                    right++;
                }
            }
        }

        // Find how many min. no. of changes are required
        count = left + right;
        Set<String> res = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(""), count);
        return new ArrayList<String>(res);
    }
    
    boolean isValid(String s) {
          int count = 0;

          for (int i = 0; i < s.length(); i++) {

          char c = s.charAt(i);

              if (c == '(')
              {
                  count++;
              }
              if (c == ')' && count-- == 0)
              {
                  return false;
              }
          }

          return count == 0;
    }

    void dfs(String s, int i, Set<String> res, StringBuilder sb, int count) {
        char c = s.charAt(i);
        int len = sb.length();

        if (c == '(' || c == ')') {
            dfs(s, i + 1, res, sb, count - 1);		    // not use ')''('
            dfs(s, i + 1, res, sb.append(c), count);       // use
        } else {
            dfs(s, i + 1, res, sb.append(c), count);
        }

        sb.setLength(len);
    }
}