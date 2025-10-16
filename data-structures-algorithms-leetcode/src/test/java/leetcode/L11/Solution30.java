package leetcode.L11;

class Solution30
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

            int localMax = 0;
            if (leftHeight <= rightHeight)
            {
                localMax = leftHeight * bottomHeight;
            }
            else
            {
                localMax = rightHeight * bottomHeight;
            }

            globalMax = Math.max(globalMax, localMax);

            // I should move indices here as well. According what logic?
        }

        return globalMax;
    }
}
