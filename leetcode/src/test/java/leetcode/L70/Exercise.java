package leetcode.L70;


/**
 * <a href="file:///home/me/1/notes/payload/heap/45fa/Algorithm%20Design%20Manual%203rd%20Ed.pdf#page=1">Open PDF Page 3</a>
 */
class Exercise
{
   public int climbStairs(int n) {
       return dfs(n, new int[n + 1]);
   }

   // What is brother of recursion? What if there were no these siblings at all?
   int dfs(int n, int[] memo)
   {
       // what is missing here (usually in the beginning of a recursive method) and how the program would behave if it is missing?

       // how do I simulate two steps?
       return dfs(n - 1, memo); // how many steps are simulated here?
   }
}