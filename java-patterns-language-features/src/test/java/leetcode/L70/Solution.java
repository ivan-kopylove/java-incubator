package leetcode.L70;


/**
 * <a href="file:///home/me/1/notes/payload/heap/45fa/Algorithm%20Design%20Manual%203rd%20Ed.pdf#page=1">Open PDF Page 3</a>
 */
class Solution {
   public int climbStairs(int n) {
       return dfs(n, new int[n + 1]);
   }

   // What is brother of recursion? What if there were no these siblings at all?
   int dfs(int n, int[] memo)
   {
       // what if there is no base case?


       // how do I simulate two steps?
       return dfs(n - 1, memo); // how many steps are simulated here?
   }
}