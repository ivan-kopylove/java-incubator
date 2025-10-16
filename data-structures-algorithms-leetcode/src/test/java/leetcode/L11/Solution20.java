package leetcode.L11;

class Solution20
{
    int maxArea(int[] height)
    {
        int globalMax = 0;

        int leftIdx = 0;
        int rightIdx = height.length - 1;

        int rightHeight = height[rightIdx];
        int leftHeight = height[leftIdx];
        int bottomHeight = 0;

        int maxLeftHeight = leftHeight;
        int maxRightHeight = rightHeight;

        while (leftIdx != rightIdx)
        {
            bottomHeight = rightIdx - leftIdx;

            // ok, I have one of the sides. How do I calculate a square?
        }

        return globalMax;
    }
}
