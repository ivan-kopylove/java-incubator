package leetcode.a11;

/**
 * @see <a href="https://leetcode.com/problems/container-with-most-water/submissions/449358581/">submission</a>
 * @see <a href="https://ivan-kopylove.github.io/leetcode/6b0b">garden</a>
 * @see <a href="obsidian://search?query=leetcode 11 container">obsidian</a>
 */
class Solution
{
    public int maxArea(int[] height)
    {
        int maxArea = 0;

        int currentLeftIndex = 0;
        int currentRightIndex = height.length - 1;

        int currentRightHeight = height[currentRightIndex];
        int currentLeftHeight = height[currentLeftIndex];
        int currentBottomHeight = 0;

        int maxLeftHeight = currentLeftHeight;
        int maxRightHeight = currentRightHeight;

        while (currentLeftIndex != currentRightIndex)
        {
            currentBottomHeight = currentRightIndex - currentLeftIndex;

            int result = 0;
            if (currentLeftHeight <= currentRightHeight)
            {
                result = currentLeftHeight * currentBottomHeight;
            }
            else
            {
                result = currentRightHeight * currentBottomHeight;
            }

            maxArea = Math.max(maxArea, result);

            if (currentLeftHeight <= currentRightHeight)
            {
                currentLeftHeight = height[++currentLeftIndex];
            }
            else
            {
                currentRightHeight = height[--currentRightIndex];
            }
        }

        return maxArea;
    }
}
