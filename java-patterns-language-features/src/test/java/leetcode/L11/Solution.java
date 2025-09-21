package leetcode.L11;

/// - [searchable problem definition](https://google.com/search?q=leetcode%2011)
/// - [garden](https://ivan-kopylove.github.io/leetcode/6b0b)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+11+container)
/// - [my submission](https://leetcode.com/problems/container-with-most-water/submissions/449358581/)
/// - [obsidian](obsidian://search?query=leetcode 11%20container)
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
